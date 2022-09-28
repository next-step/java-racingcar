package racingcar.step3;

import java.util.Random;

public class Game {

	private static final Random random = new Random();
	private static final int LIMIT = 10;
	private static final RandomValueGenerator randomValueGenerator = () -> random.nextInt(LIMIT);

	private final ResultView resultView;

	public Game(ResultView resultView) {
		this.resultView = resultView;
	}

	public void play(GameAttribute gameAttribute) {
		Cars cars = Cars.createCars(gameAttribute.getCarCount());
		for (int i = 0; i < gameAttribute.getTryCount(); i++) {
			cars.move(randomValueGenerator);
			resultView.printEachTryResult(cars.getCars());
		}
	}
}
