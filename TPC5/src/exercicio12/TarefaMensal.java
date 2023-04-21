package exercicio12;
import java.time.LocalDate;
public class TarefaMensal extends Tarefa {
    private int diaDoMes;

    public TarefaMensal(String descricao, LocalDate data, int diaDoMes) {
        super(descricao, data);
        this.diaDoMes = diaDoMes;
    }

    @Override
    public boolean ocorreEm(int year, int month, int day) {
        return this.diaDoMes == day;
    }
}