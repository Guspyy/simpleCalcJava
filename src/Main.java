import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args){

        int opcao = 0;

        float n1 = 0F;
        float n2 = 0F;
        float resultado = 0F;
        char operacao = 'n';

        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("-=-=-=-CALCULADORA-=-=-=-");
            System.out.print("Digite o 1o número: ");
            n1 = scan.nextFloat();
            System.out.print("Digite o 2o número: ");
            n2 = scan.nextFloat();

            System.out.printf("Que operação você deseja fazer\n" +
                    "[0] - Sair\n" +
                    "[1] - Soma\n" +
                    "[2] - Subtrair\n" +
                    "[3] - Multiplicação\n" +
                    "[4] - Divisão\n" +
                    "> ");
            opcao = scan.nextInt();
            switch (opcao){
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                case 1:
                    resultado = SOMA.somar(n1, n2);
                    operacao = '+';
                    break;
                case 2:
                    resultado = SUBTRACAO.subtrair(n1, n2);
                    operacao = '-';
                    break;
                case 3:
                    resultado = MULTIPLICACAO.multiplicar(n1, n2);
                    operacao = 'x';
                    break;
                case 4:
                    resultado = DIVISAO.dividir(n1, n2);
                    operacao = '/';
                    break;
            }

            System.out.printf("%.2f %c %.2f = %.2f\n", n1, operacao, n2, resultado);

            try (FileWriter writer = new FileWriter("teste.txt", true)){
                String linhaEscrita = String.format("-OPERACAO-\n" +
                        "%.2f %c %.2f = %.2f\n", n1, operacao, n2, resultado);
                writer.write(linhaEscrita);
                writer.close();
            } catch (IOException e){
                System.out.println("Erro: " + e);
            }
        }
    }
}

class SOMA {
    public static float somar(float a, float b){
        return a+b;
    }
}

class SUBTRACAO {
    public static float subtrair(float a, float b){
        return a-b;
    }
}

class MULTIPLICACAO {
    public static float multiplicar(float a, float b){
        return a*b;
    }
}

class DIVISAO {
    public static float dividir(float a, float b){
        return a/b;
    }
}