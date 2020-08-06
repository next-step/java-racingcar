package simpleracing.execute;

import java.util.Random;

public class CarRacingGame implements CarGame {

	private static final int RANDOM_MAX_VALUE = 10;
	private Random randomValueGenerator;

	public CarRacingGame() {
		this.randomValueGenerator = new Random();
	}

	@Override
	public void play(Car car) {
		int randomValue = randomValueGenerator.nextInt(RANDOM_MAX_VALUE);
		car.move(Direction.getBy(randomValue));
	}
}
