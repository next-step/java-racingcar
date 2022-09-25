package racingcar;

public class Car implements Comparable<Car> {

	private int position = 0;
	private final NumberStrategy numberStrategy;

	public Car(NumberStrategy numberStrategy) {
		this.numberStrategy = numberStrategy;
	}

	public void move() {
		int generated = numberStrategy.generate();
		if (generated >= 4) {
			position += 1;
		}
	}

	@Override
	public int compareTo(Car other) {
		return Integer.compare(position, other.position);
	}
}
