package exercicio12;
import java.time.LocalDate;

public class TarefaDiaria extends Tarefa {
    public TarefaDiaria(String descricao, LocalDate data) {
        super(descricao, data);
    }

    @Override
    public boolean ocorreEm(int year, int month, int day) {
        return true;
    }
}
