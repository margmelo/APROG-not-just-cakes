/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author 1181092
 */
public class main {

    static Scanner ler = new Scanner(System.in);

    static String[] vendedores;
    static String[] tiposbolo;
    static double[][] nbolospreco;
    static int[][] nnormalvegan = new int[3][2];
    static String[] nomeVendedor = { "Ana", "Beatriz", "Cláudio" };

    public static boolean lerVendas(int i) {
        String vendedor, tbolo;
        vendedor = "";
        tbolo = "";
        int vendedor_num = 0;
        int bolo_num = 0;
        System.out.println();
        System.out.println("VENDA N: " + (int) (i + 1));
        System.out.println("Quem é o vendedor? Ana, Beatriz ou Cláudio?");
        vendedor = ler.next();
        if (vendedor.equalsIgnoreCase("Ana") || vendedor.equalsIgnoreCase("Beatriz") || vendedor.equalsIgnoreCase("Claudio")) {
            if (vendedor.equalsIgnoreCase("Ana")) {
                vendedor_num = 0;
            } else if (vendedor.equalsIgnoreCase("Beatriz")) {
                vendedor_num = 1;
            } else {
                vendedor_num = 2;
            }

            vendedores[i] = vendedor;
            System.out.println("Qual é o tipo de bolo? normal ou vegan?");
            tbolo = ler.next();

            while (!tbolo.equalsIgnoreCase("vegan") && !tbolo.equalsIgnoreCase("normal")) {
                System.out.println("ERRO! Opção Invalida\nQual o tipo de bolo vendido? (normal/vegan)");
                tbolo = ler.next();
            }

            if (tbolo.equalsIgnoreCase("vegan")) {
                bolo_num = 0;
            } else {
                bolo_num = 1;
            }

            tiposbolo[i] = tbolo;
            System.out.println("Qual a quantidade de bolos?");
            nbolospreco[i][0] = ler.nextDouble();
            nnormalvegan[vendedor_num][bolo_num] += nbolospreco[i][0];

            System.out.println("Qual o preço dos bolos?");
            nbolospreco[i][1] = ler.nextDouble();

            return true;

        } else {

            System.out.println("Nome inválido");

            return false;
        }
    }

    public static void main(String[] args) {
        int nvendas;
        boolean vendaValida = false;

        System.out.println("Qual o número total de vendas realizado?");
        nvendas = ler.nextInt();

        vendedores = new String[nvendas];
        tiposbolo = new String[nvendas];
        nbolospreco = new double[nvendas][2];

        for (int i = 0; i < nvendas; i++) {
            vendaValida = lerVendas(i);

            if (vendaValida == false) {
                i--;
            }
        }
        double percVegan = percentagemvegan(tiposbolo, nvendas, nbolospreco);
        double percNormal = 100 - percVegan;
        double percvvegan = percentagemvvegan(tiposbolo, nvendas);
        double percvnormal = 100 - percvvegan;
        System.out.println();
        System.out.println("Percentagem de vendas por tipo de bolo");
        System.out.printf("=> Normal: %.0f ; Vegan: %.0f  ", percvnormal, percvvegan);
        System.out.println();
        System.out.println("Percentagem de bolos vendidos por tipo");
        System.out.printf("=> Normal: %.0f  Vegan: %.0f ", percNormal, percVegan);
        System.out.println();
        int quantidadebolos = quantidadetotaldebolos(nbolospreco, nvendas);
        System.out.println("Quantidade total de bolos vendidos");
        System.out.println("=> " + quantidadebolos);
        System.out.println();
        System.out.println("Vendedores e quantidades de bolos que venderam de bolos do tipo Normal:");
        System.out.print("=> ");
        topvendasnormal(nnormalvegan);
        System.out.println();
        System.out.println();
        System.out.println("Vendedores e quantidades de bolos que venderam de bolos do tipo Vegan;");
        System.out.print("=> ");
        topvendasvegan(nnormalvegan);
        System.out.println();
        System.out.println();
        System.out.println("O vendedor que realizou a venda de maior valor e o respetivo valor");
        System.out.println("=> " + nomeVendedor[maiorvenda()] + ": " + nbolospreco[maiorvenda()][1] + " €");
        System.out.println();
        System.out.println("Quantidade média de bolos por venda");
        System.out.println("=> " + quantidadebolosporvenda(nbolospreco, nvendas));
        System.out.println();
        System.out.println("Valor médio por venda");
        System.out.println("=> " + valormediovenda(nbolospreco, nvendas));
    }

    public static int quantidadetotaldebolos(double[][] arr, int nvendas) {
        int somaquantidade = 0;
        for (int l = 0; l < nvendas; l++) {
            somaquantidade += arr[l][0];
        }
        return somaquantidade;
    }

    public static double quantidadebolosporvenda(double[][] arr, int nvendas) {
        int somaquantidade = 0;
        for (int l = 0; l < nvendas; l++) {
            somaquantidade += arr[l][0];
        }
        return ((double) somaquantidade / (double) nvendas);
    }

    public static double valormediovenda(double[][] arr, int nvendas) {
        int somapreco = 0;
        for (int l = 0; l < nvendas; l++) {
            somapreco += arr[l][1];
        }
        return ((double) somapreco / (double) nvendas);
    }

    public static double percentagemvegan(String[] tipobolo, int nvendas, double[][] nbolospreco) {
        double percvegan, nvendasvegan = 0;
        for (int i = 0; i < nvendas; i++) {
            if (tipobolo[i].equals("vegan")) {
                nvendasvegan += nbolospreco[i][0];
            }
        }
        percvegan = (double) nvendasvegan / (double) quantidadetotaldebolos(nbolospreco, nvendas);

        return ((double) percvegan * 100.0);
    }

    public static int maiorvenda() {
        int linhaMaior = 0;
        int nvendas = nomeVendedor.length;

        for (int i = 0; i < nvendas; i++) {
            if (nbolospreco[i][1] > nbolospreco[linhaMaior][1]) {
                linhaMaior = i;
            }
        }

        return linhaMaior;
    }

    public static void topvendasvegan(int[][] nnormalvegan) {
        int[][] newaux = new int[3][3];
        for (int i = 0; i < nnormalvegan.length; i++) {
            newaux[i][0] = nnormalvegan[i][0];
            newaux[i][1] = nnormalvegan[i][1];
            newaux[i][2] = i;
        }
        for (int idx1 = 0; idx1 < newaux.length - 1; idx1++) {
            for (int idx2 = idx1 + 1; idx2 < newaux.length; idx2++) {
                if (newaux[idx2][0] > newaux[idx1][0]) {
                    int[] aux = newaux[idx1];
                    newaux[idx1] = newaux[idx2];
                    newaux[idx2] = aux;
                }
            }
        }
        for (int i = 0; i < newaux.length; i++) {
            System.out.print("" + nomeVendedor[newaux[i][2]] + ": " + newaux[i][0] + "; ");
        }
    }

    public static void topvendasnormal(int[][] nnormalvegan) {
        int[][] newaux = new int[3][3];
        for (int i = 0; i < nnormalvegan.length; i++) {
            newaux[i][0] = nnormalvegan[i][0];
            newaux[i][1] = nnormalvegan[i][1];
            newaux[i][2] = i;
        }
        for (int idx1 = 0; idx1 < newaux.length - 1; idx1++) {
            for (int idx2 = idx1 + 1; idx2 < newaux.length; idx2++) {
                if (newaux[idx2][1] > newaux[idx1][1]) {
                    int[] aux = newaux[idx1];
                    newaux[idx1] = newaux[idx2];
                    newaux[idx2] = aux;
                }
            }
        }
        for (int i = 0; i < newaux.length; i++) {
            System.out.print("" + nomeVendedor[newaux[i][2]] + ":  " + newaux[i][1] + "; ");
        }
    }

    public static double percentagemvvegan(String[] tiposbolo, int nvendas) {
        double percvegan, nvendasvegan = 0;

        for (int i = 0; i < nvendas; i++) {
            if (tiposbolo[i].equals("vegan")) {
                nvendasvegan++;
            }
        }
        percvegan = (double) nvendasvegan / (double) nvendas;

        return ((double) percvegan * 100.0);
    }
}
