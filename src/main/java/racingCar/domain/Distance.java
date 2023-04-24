package racingCar.domain;

public class Distance {
	private int amount;

	public int getAmount() {
		return amount;
	}

	public Distance(int amount) {
		this.amount = amount;
	}

	public static Distance from(int amount) {
		return new Distance(amount);
	}

	public static Distance create() {
		return new Distance(0);
	}

	public void addDistance() {
		this.amount++;
	}

}
