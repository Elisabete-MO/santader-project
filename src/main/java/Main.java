import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o primeiro salário:");
        double bruto1 = scanner.nextDouble();
        System.out.println("Informe o segundo salário:");
        double bruto2 = scanner.nextDouble();
        System.out.println("Informe o terceiro salário:");
        double bruto3 = scanner.nextDouble();
        System.out.println("Informe o quarto salário:");
        double bruto4 = scanner.nextDouble();
        System.out.println("Informe o quinto salário:");
        double bruto5 = scanner.nextDouble();

        calcularSalario(bruto1);
        calcularSalario(bruto2);
        calcularSalario(bruto3);
        calcularSalario(bruto4);
        calcularSalario(bruto5);
    }

    public static void calcularSalario(double bruto) {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("******************************");
        System.out.println("Salário bruto: R$ " + df.format(bruto));

        double descontoINSS = calcularInss(bruto);
        System.out.println("Desconto INSS: R$ " + df.format(descontoINSS));

        double descontoIR = calcularImpostoDeRenda(bruto);
        System.out.println("Desconto Imposto de Renda: R$ " + df.format(descontoIR));

        double salarioLiquido = calcularSalarioLiquido(bruto, descontoINSS, descontoIR);
        System.out.println("Salário líquido: R$ " + df.format(salarioLiquido));
    }


    public static double calcularInss(double bruto) {
        if (bruto <= 1212) {
            return (bruto * 0.075);
        } else if (bruto <= 2427.35) {
            return (bruto * 0.09);
        } else if (bruto <= 3641.03) {
            return (bruto * 0.12);
        } else {
        return (bruto * 0.14);
        }
    }

    public static double calcularImpostoDeRenda(double bruto) {
        if (bruto <= 1903.98) {
            return 0;
        } else if (bruto <= 2826.65) {
            return (bruto * 0.075);
        } else if (bruto <= 3751.05) {
            return (bruto * 0.15);
        } else if (bruto <= 4664.68) {
            return (bruto * 0.225);
        } else {
            return (bruto * 0.275);
        }
    }

    public static double calcularSalarioLiquido(double bruto, double descontoINSS,
                                                double descontoIR) {
        return bruto - descontoINSS - descontoIR;
    }
}
