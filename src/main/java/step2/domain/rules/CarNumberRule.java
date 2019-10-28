package step2.domain.rules;

public abstract class CarNumberRule {

	private int carNumber;

	CarNumberRule(int carNumber) {
		this.carNumber = validate(carNumber);
	}

	public abstract int validate(int carNumber);

	public int getCarNumber() {
		return carNumber;
	}

}
