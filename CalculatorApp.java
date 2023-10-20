import java.util.Scanner;

// Interface para definir as estratégias de operação
interface Operation {
    double execute(double a, double b);
}

// Implementações das estratégias
class Addition implements Operation {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}

class Subtraction implements Operation {
    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}

class Multiplication implements Operation {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}

class Division implements Operation {
    @Override
    public double execute(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Erro: Divisão por zero.");
            return Double.NaN;
        }
    }
}

// Classe da calculadora
class Calculator {
    private Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double a, double b) {
        return operation.execute(a, b);
    }
}

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Adição");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Sair");

            int choice = scanner.nextInt();
            if (choice == 5) {
                System.out.println("Encerrando a calculadora.");
                break;
            }

            Operation selectedOperation = null;
            switch (choice) {
                case 1:
                    selectedOperation = new Addition();
                    break;
                case 2:
                    selectedOperation = new Subtraction();
                    break;
                case 3:
                    selectedOperation = new Multiplication();
                    break;
                case 4:
                    selectedOperation = new Division();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            if (selectedOperation != null) {
                calculator.setOperation(selectedOperation);
                System.out.print("Digite o primeiro número: ");
                double a = scanner.nextDouble();
                System.out.print("Digite o segundo número: ");
                double b = scanner.nextDouble();
                double result = calculator.calculate(a, b);
                System.out.println("Resultado: " + result);
            }
        }
    }
}
