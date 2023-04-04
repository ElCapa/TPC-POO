import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int numeroInteiro = random.nextInt(10) + 1;
        System.out.println("Número inteiro aleatório: " + numeroInteiro);

        double numeroDouble = random.nextDouble();
        System.out.println("Número double aleatório: " + numeroDouble);

        float numeroFloat = random.nextFloat();
        System.out.println("Número float aleatório: " + numeroFloat);

        boolean valorBooleano = random.nextBoolean();
        System.out.println("Valor booleano aleatório: " + valorBooleano);
    }
}