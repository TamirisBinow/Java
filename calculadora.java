import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner calculadoraScanner = new Scanner(System.in); // falando que estou criando um scanner chamado
                                                             // "calculadora scanner"

        System.out.println("Digite o primeiro número:");
        double nota1 = calculadoraScanner.nextDouble(); // em "double" eu uso o tipo da variavel
        calculadoraScanner.nextLine(); // Consome a quebra de linha pendente após nextDouble()
        // usei esse comando de cima pq se eu usar o tipo "nextLine" depois de alguma
        // outra, n da

        System.out.println("Digite o operador que deseja (+, -, *, /):");
        String operador = calculadoraScanner.nextLine(); // Tipo String com 'S' maiúsculo

        System.out.println("Digite o segundo número:");
        double nota2 = calculadoraScanner.nextDouble();
        // Não precisa de nextLine() aqui se for a última leitura de número antes de
        // fechar o Scanner

        if (operador.equals("+")) { // Usa .equals() para comparar strings
            System.out.println("O resultado da soma é: " + (nota1 + nota2)); // Concatena corretamente
        } else if (operador.equals("-")) {
            System.out.println("O resultado da subtração é: " + (nota1 - nota2));
        } else if (operador.equals("*")) {
            System.out.println("O resultado da multiplicação é: " + (nota1 * nota2));
        } else {
            System.out.println("O resultado da divisão é: " + (nota1 / nota2));

        }
        calculadoraScanner.close(); // importante fechar o scanner
    }
}