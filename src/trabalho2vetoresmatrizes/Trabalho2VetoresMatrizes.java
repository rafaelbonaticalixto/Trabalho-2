/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2vetoresmatrizes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.text.html.MinimalHTMLWriter;

/**
 *
 * @author 10764999613
 */
public class Trabalho2VetoresMatrizes {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {

		String arquivo = "C:\\Users\\10764999613\\Documents\\NetBeansProjects\\Trabalho2VetoresMatrizes\\src\\trabalho2vetoresmatrizes\\Entrada.txt";

		try {
			System.setIn(new FileInputStream(new File(arquivo)));
		} catch (FileNotFoundException e) {
			System.out.println("Sem arquivo");
		}

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(new Locale("en", "US"));
		sc.useLocale(Locale.ENGLISH);

		String nome[], telefone[];
		int i, N, tipo[], Min[], j, pos, divide1 = 0, SumMin = 0, qtd = 0;
		double VlrConta[], plano[][], RecTot, m, media2 = 0, MedMin;

		N = sc.nextInt();

		nome = new String[N];
		telefone = new String[N];
		tipo = new int[N];
		Min = new int[N];
		VlrConta = new double[N];
		plano = new double[3][2];


		for (i = 0; i < 3; i++) {
			plano[i][0] = sc.nextDouble();
			plano[i][1] = sc.nextDouble();
		}

		for (i = 0; i < N; i++) {
			sc.nextLine();
			nome[i] = sc.nextLine();
			telefone[i] = sc.next();
			tipo[i] = sc.nextInt();
			Min[i] = sc.nextInt();

		}

		for (i = 0; i < N; i++) {
			if (Min[i] <= 90) {
				VlrConta[i] = plano[tipo[i]][0];
			} else {
				VlrConta[i] = plano[tipo[i]][0] + (Min[i] - 90) * plano[tipo[i]][1];
			}

		}
		String texto = "";

		for (i = 0; i < N; i++) {
			texto += "\n"+nome[i] + "\t\t" + 
					telefone[i] + "\t\t" + 
					tipo[i] + "\t\t" + 
					Min[i] + "\t\t"+ 
					VlrConta[i];
		}		

		System.out.println( "Nome \t\t Telefone \t\t Tipo\t\t Minutos \t\tValorDaConta "+ texto);
		
		RecTot = 0;
		for (i = 0; i < N; i++) {
			RecTot += VlrConta[i];
		}
		System.out.println("\nReceita Total:" + RecTot);

		m = VlrConta[0];
		pos = 0;
		for (i = 0; i < N; i++) {
			if (m > VlrConta[i]) {
				m = VlrConta[i];
				pos = i;
			}
		}
		System.out.println("\nNome e telefone do cliente do qual a conta foi mais barata é "+ nome[pos] + " e o telefone é " + telefone[pos]);

		for (i = 0; i < N; i++) {
			if (tipo[i] == 1) {
				SumMin += Min[i];
				divide1++;
			}
		}
		MedMin = (double) SumMin / divide1;
		System.out.println("\nMédia de minutos consumidos por clientes de conta tipo 1: " + MedMin);

		System.out.println("\nNomes e telefones dos clientes que não consumiram minutos excedentes.");
		for (i = 0; i < N; i++) {
			if (Min[i] <= 90) {

				System.out.println("Nome : " + nome[i]);
				System.out.println("Telefone : " + telefone[i]);
			}
		}

		for (i = 0; i < N; i++) {
			if (Min[i] >= 120) {
				qtd++;
			}
		}
		System.out.println("\nA quantidade de clientes que consumiu acima de 120 minutos é " + qtd);

		qtd = 0;
		
		for (i = 0; i < N; i++) {
			if (tipo[i] == 2) {
				qtd++;
			}
		}
		media2 = (double) (qtd * 100) / N;
		System.out.println("\nA porcentagem de clientes que possuem conta tipo 2, em relação ao total de clientes é " + media2 + " %");
	}
}
