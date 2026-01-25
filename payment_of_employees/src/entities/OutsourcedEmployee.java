package entities;

public class OutsourcedEmployee extends Employee{
	private Double additionalCharge;
	
	public OutsourcedEmployee() {
	}
	
	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	@Override
	public final double payment() {
		return valuePerHour * hours + (1.10 * additionalCharge);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " - $ " + String.format("%.2f", payment()));
		return sb.toString();
	}
}
