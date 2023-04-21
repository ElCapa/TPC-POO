package exercicio13;
import exercicio12.Tarefa;

import java.time.LocalDate;
import java.util.ArrayList;

public class Collection {
    private ArrayList<Tarefa> tarefas;

    public Collection() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public void modificarTarefa(int i, Tarefa novaTarefa) {
        this.tarefas.set(i, novaTarefa);
    }

    public void removerTarefa(int i) {
        this.tarefas.remove(i);
    }

    public void listarTarefas(LocalDate data) {
        for (int i = 0; i < this.tarefas.size(); i++) {
            Tarefa tarefa = this.tarefas.get(i);
            if (tarefa.ocorreEm(data.getYear(), data.getMonthValue(), data.getDayOfMonth())) {
                System.out.println(tarefa.getDescricao());
            }
        }
    }
}
