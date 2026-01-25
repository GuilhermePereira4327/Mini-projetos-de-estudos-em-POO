package entities;

public class Company extends TaxPlayer{
	private Integer numberOfEmployees; 
	
	public Company() {
	}

	public Company(String name, Double annualIncome, Integer numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tax() {
		if(numberOfEmployees < 10) {
			return anualIncome * 0.16;
		}else {
			return anualIncome * 0.14;
		}
	}

	@Override
	public String toString() {
		return name + ": $ " + String.format("%.2f", tax());
	}
}
