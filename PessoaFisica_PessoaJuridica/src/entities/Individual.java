package entities;

public class Individual extends TaxPlayer{
	private Double healthExpenditures;
	
	public Individual(){
	}
	
	public Individual(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		if(anualIncome < 20000.00) {
			return (anualIncome * 0.15) - (healthExpenditures * 0.5);
		}else {
			return (anualIncome * 0.25) - (healthExpenditures * 0.5);
		}
	}

	@Override
	public String toString() {
		return name + ": $ " + String.format("%.2f", tax());
	}
}
