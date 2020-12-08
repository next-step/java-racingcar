package step3;

public class Car {
	private int location;

	public boolean checkIfMove() {
		return NumberUtil.generateRandomDigit() >= 4;
	}

	public void tryToMove() {
		if (checkIfMove()) {
			location++;
		}
	}

	public int getLocation() {
		return location;
	}
}