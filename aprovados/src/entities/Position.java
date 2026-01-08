package entities;

public class Position {
	private String name;
	private double notas1;
	private double notas2;
	private double mediaNotas;
	
	public Position(String name, double notas1, double notas2) {
		this.name = name;
		this.notas1 = notas1;
		this.notas2 = notas2;
	}

	public Position(double mediaNotas) {
		this.mediaNotas = mediaNotas;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNotas1() {
		return notas1;
	}

	public void setNotas1(double notas1) {
		this.notas1 = notas1;
	}

	public double getNotas2() {
		return notas2;
	}

	public void setNotas2(double notas2) {
		this.notas2 = notas2;
	}

	public double getMediaNotas() {
		return mediaNotas;
	}

	public void setMediaNotas(double mediaNotas) {
		this.mediaNotas = mediaNotas;
	}
	
}
