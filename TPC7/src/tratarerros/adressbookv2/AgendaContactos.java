package tratarerros.adressbookv2;

import tratarerros.adressbookv2.exceptions.AgendaVaziaException;
import tratarerros.adressbookv2.exceptions.ChaveComDuplicado;
import tratarerros.adressbookv2.exceptions.ContactoInexistenteException;
import tratarerros.adressbookv2.exceptions.DuplicateKeyException;

import java.util.*;

/**
 * Uma classe para manter um número diverso de contato.
 * Os detalhes são indexados por nome e número de telefone.
 *
 * @autor Paulo
 * @versão 2023.05.12
 */
public class AgendaContactos {
    // // Armazenamento para detalhes de contacto.
    private TreeMap<String, DetalhesContacto> agenda;
    private int qtDeEntradas;

    /**
     * Execute inicialização para a agenda de contactos.
     */
    public AgendaContactos() {
        agenda = new TreeMap<>();
        qtDeEntradas = 0;
    }

    /**
     * Procure um nome ou número de telefone e retorne o
     * detalhes de contato correspondentes.
     *
     * @param key O nome ou número a ser pesquisado.
     * @return Os detalhes correspondentes à chave.
     */
    public DetalhesContacto obterDetalhes(String key) throws ContactoInexistenteException {
        if (key == null) {
            throw new NullPointerException(
                    "null key em obterDetalhes");
        } else if (key.trim().equals("")) {
            throw new IllegalArgumentException("Não é aceite String vazia como argumento");
        }
        if (chaveEmUso(key)) {
            return agenda.get(key);
        } else
            throw new ContactoInexistenteException(key);

    }

    /**
     * Retorna se a chave atual está ou não em uso.
     *
     * @param key O nome ou número a ser pesquisado.
     * @return true se a chave estiver em uso, false caso contrário.
     */
    public boolean chaveEmUso(String key) {
        return agenda.containsKey(key);
    }

    /**
     * Adicione um novo Contacto à agenda.
     *
     * @param details Os detalhes a serem associados à pessoa.
     */
    public void addDetails(DetalhesContacto details) throws DuplicateKeyException {
    if (!chaveEmUso(details.getNome()) && !chaveEmUso(details.getTelefone()) ) {
        agenda.put(details.getNome(), details);
        agenda.put(details.getTelefone(), details);
        qtDeEntradas++;
    } else {
        if (chaveEmUso(details.getNome()) ) {
            throw new DuplicateKeyException(details.getNome(), ChaveComDuplicado.NOME);
        } else if (chaveEmUso(details.getTelefone())) {
            throw new DuplicateKeyException(details.getTelefone(), ChaveComDuplicado.TELEFONE);
        }
    }

    }

    /**
     * Altere os detalhes armazenados anteriormente na chave fornecida.
     *
     * @param oldKey  Uma das chaves usadas para armazenar os detalhes.
     * @param details Os detalhes da substituição.
     */
    public void alterarDetalhes(String oldKey,
                                DetalhesContacto details) throws ContactoInexistenteException, DuplicateKeyException {

            removeDetails(oldKey);
            addDetails(details);

    }


    /**
     * Pesquise todos os detalhes armazenados em uma chave que começa com
     * o prefixo fornecido.
     *
     * @param keyPrefix O prefixo da chave a ser pesquisado.
     * @return Um array dos detalhes que foram encontrados.
     */
    public DetalhesContacto[] search(String keyPrefix) {
        // Constrói uma lista das correspondências.
        List<DetalhesContacto> matches = new LinkedList<>();
        // Encontra chaves que são iguais ou maiores que o prefixo.
        SortedMap<String, DetalhesContacto> tail = agenda.tailMap(keyPrefix);
        Iterator<String> it = tail.keySet().iterator();
        // Para quando encontramos uma incompatibilidade.
        boolean endOfSearch = false;
        while (!endOfSearch && it.hasNext()) {
            String key = it.next();
            if (key.startsWith(keyPrefix)) {
                matches.add(agenda.get(key));
            } else {
                // À medida que a lista for ordenada, não haverá mais nenhuma.
                endOfSearch = true;
            }
        }
        DetalhesContacto[] results = new DetalhesContacto[matches.size()];
        matches.toArray(results);
        return results;
    }

    /**
     * Retorna o número de entradas atualmente no
     * agenda de endereço.
     *
     * @return O número de entradas.
     */
    public int getQtDeEntradas() {
        return qtDeEntradas;
    }

    /**
     * Remova uma entrada com a chave fornecida da agenda de endereços.
     *
     * @param key Uma das chaves da entrada a ser removida.
     */
    public void removeDetails(String key) throws ContactoInexistenteException {
        if (chaveEmUso(key)) {
            DetalhesContacto details = agenda.get(key);

            agenda.remove(details.getNome());
            agenda.remove(details.getTelefone());
            qtDeEntradas--;
        } else {
            throw new ContactoInexistenteException(key);
        }
    }

    /**
     * Retornar todos os detalhes de contato, classificados de acordo
     * à ordem de ordenação da classe DetalhesContacto.
     *
     * @return Uma lista ordenada dos detalhes.
     */
    public String listaDetalhes() throws AgendaVaziaException {
        // Como cada entrada é armazenada em duas chaves, é
        // necessário para construir um conjunto de DetalhesContacto. Esse
        // elimina duplicatas.
        if (agenda.size() > 0) {
            StringBuilder allEntries = new StringBuilder();
            Set<DetalhesContacto> sortedDetails = new TreeSet<>(agenda.values());
            for (DetalhesContacto details : sortedDetails) {
                allEntries.append(details).append("\n\n");
            }
            return allEntries.toString();
        } else
            throw new AgendaVaziaException();

    }
}
