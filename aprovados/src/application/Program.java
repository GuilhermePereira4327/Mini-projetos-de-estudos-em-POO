package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Position;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas alunos vai digitar? ");
		int n = sc.nextInt();
		Position[] posicao = new Position[n];
		sc.nextLine();
		
		for(int i = 0; i < posicao.length; i++) {
			System.out.println("digite nome, primeira e segunda nota do  " + (i+1) + "o aluno:");
			String name = sc.nextLine();  
			double nota1 = Double.parseDouble(sc.nextLine()); 
            double nota2 = Double.parseDouble(sc.nextLine()); 
			posicao[i] = new Position(name, nota1, nota2);
		}
		
		for(int i = 0; i < posicao.length; i++) {
			posicao[i].setMediaNotas((posicao[i].getNotas1() + posicao[i].getNotas2()) / 2);
		}
		
		System.out.println("Alunos aprovados: ");
		for(int i = 0; i < posicao.length; i++) {
			if(posicao[i].getMediaNotas() >= 6.0) {
				System.out.printf("%s\n", posicao[i].getName());
			}
		}
		
		
		sc.close();
	}

}
