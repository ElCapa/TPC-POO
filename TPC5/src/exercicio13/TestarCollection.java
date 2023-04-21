package exercicio13;
import java.time.LocalDate;
import exercicio12.TarefaDiaria;
import exercicio12.TarefaMensal;
import exercicio12.TarefaUnica;

public class TestarCollection {
        public static void main(String[] args) {
            Collection colecao = new Collection();

            colecao.adicionarTarefa(new TarefaUnica("Compara agua", LocalDate.of(2023, 4, 10)));
            colecao.adicionarTarefa(new TarefaDiaria("Ir para escola", LocalDate.of(2023, 4, 20)));
            colecao.adicionarTarefa(new TarefaMensal("Pagar internet", LocalDate.of(2023, 4, 30), 10));

            colecao.listarTarefas(LocalDate.of(2023, 4, 10));
        }
}
