package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Renda anual com salário: ");
        double salarioAnual = sc.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        double prestacaoServico = sc.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        double ganhoCapital = sc.nextDouble();
        System.out.print("Gastos médicos: ");
        double gastosMedicos = sc.nextDouble();
        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = sc.nextDouble();

        System.out.println();
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
        System.out.println();

        double impostoSalario;
        double impostoServico = 0.0;
        double impostoCapital = 0.0;
        double salarioMes = salarioAnual / 12.0;

        System.out.println("CONSOLIDADO DE RENDA: ");

        if (salarioMes < 3000.00) {
            impostoSalario = 0.00;
        }
        else if (salarioMes < 5000.00 ) {
            impostoSalario = salarioMes * 0.10 * 12.0;
        }
        else {
            impostoSalario = salarioMes * 0.20 * 12;
        }

        if (prestacaoServico != 0.0) {
            impostoServico = prestacaoServico * 0.15;
        }

        if (ganhoCapital != 0) {
            impostoCapital = ganhoCapital * 0.20;
        }

        System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f%n", impostoServico);
        System.out.printf("Imposto sobre ganho capital: %.2f%n%n", impostoCapital);

        double gastosDedutiveis = gastosMedicos + gastosEducacionais;
        double impostoBrutoAbatido = (impostoSalario + impostoServico + impostoCapital) * 0.30;
        double maximoDedutivel, abatimento;

        if (impostoBrutoAbatido < gastosDedutiveis) {
            maximoDedutivel = impostoBrutoAbatido;
            abatimento = maximoDedutivel;
        }
        else {
            maximoDedutivel = impostoBrutoAbatido;
            abatimento = gastosDedutiveis;
        }

        System.out.println("DEDUÇÕES: ");
        System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f%n%n", gastosDedutiveis);

        double impostoBruto = impostoBrutoAbatido / 0.30;
        double impostoDevido = impostoBruto - abatimento;

        System.out.println("RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", impostoBruto);
        System.out.printf("Abatimento: %.2f%n", abatimento);
        System.out.printf("Imposto devido %.2f%n", impostoDevido);


        sc.close();
    }
}
