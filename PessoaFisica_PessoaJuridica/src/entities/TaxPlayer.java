package entities;

public abstract class TaxPlayer {
	protected String name;
	protected Double anualIncome;
	
	public TaxPlayer() {
	}

	public TaxPlayer(String name, Double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnualIncome() {
		return anualIncome;
	}

	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}
	
	public abstract double tax();
	
	public abstract String toString();
}
