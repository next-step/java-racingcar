package step2.domain;

public class Car {

	private static final int THRESHOLD = 4;

	private final String name;
	private int step;

	public Car(String name, int step) {
		this.name = name;
		this.step = step;
	}

	public void move(int number) {
		if (isEnoughToMove(number)) {
			step++;
		}
	}

	private boolean isEnoughToMove(int number) {
		return number >= THRESHOLD;
	}

	boolean hasSameStep(int step) {
		return this.step == step;
	}

	public int getStep() {
		return step;
	}

	public String getName() {
		return name;
	}

}
