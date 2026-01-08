package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Position;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas voce vai digitar? ");
		int n = sc.nextInt();
		Position[] posicao = new Position[n];
		
		for(int i = 0; i < posicao.length; i++) {
			System.out.print("Altura da " + (i+1) + "a pessoa: ");
			double height = sc.nextDouble(); 
			System.out.print("Genero da " + (i+1) + "a pessoa: ");
			char gender = sc.next().charAt(0);
			posicao[i] = new Position(gender, height);
		}
		
		double menorAltura = posicao[0].getHeight();
		for(int i = 1; i < posicao.length; i++) {
			if(menorAltura > posicao[i].getHeight()) {
				menorAltura = posicao[i].getHeight();
			}
		}
		System.out.println("Menor altura = " + String.format("%.2f", menorAltura));
		
		double maiorAltura = posicao[0].getHeight();
		for(int i = 0; i < posicao.length; i++) {
			if(maiorAltura < posicao[i].getHeight()) {
				maiorAltura = posicao[i].getHeight();
			}
		}
		System.out.println("Maior altura = " + String.format("%.2f", maiorAltura));

		double somaMedia = 0.0;
		int counter = 0;
		for(int i = 0; i < posicao.length; i++) {
			if(posicao[i].getGender() == 'f' || posicao[i].getGender() == 'F') {
				somaMedia += posicao[i].getHeight();
				counter += 1;
			}
		}
		double mediaAltura = somaMedia / counter;
		System.out.println("Media das alturas das mulheres = " + String.format("%.2f", mediaAltura));
		
		counter = 0;
		for(int i = 0; i < posicao.length; i++) {
			if(posicao[i].getGender() == 'm' || posicao[i].getGender() == 'M') {
				counter += 1;
			}
		}
		System.out.println("Numeros de homens = " + counter);
		
		sc.close();
	}

}
