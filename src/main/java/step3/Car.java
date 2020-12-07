package step3;

public class Car {
	private static final int MIN_MOVABLE_NUMBER = 4;

	private int position;
	private final NumberGenerator numberGenerator;

	public Car(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public void goOrStop() {
		int no = numberGenerator.generate();

		if (isGo(no)) {
			position++;
		}
	}

	boolean isGo(int no) {
		return isGreaterThanOrEqualToMinMovableNumber(no);
	}

	private boolean isGreaterThanOrEqualToMinMovableNumber(int no) {
		return no >= MIN_MOVABLE_NUMBER;
	}

	public int getPosition() {
		return this.position;
	}
}
