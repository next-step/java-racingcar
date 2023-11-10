package carracing;

import carracing.car.Car;
import carracing.car.Cars;
import carracing.car.MaxMoving;
import carracing.car.MovingStrategy;
import carracing.car.RacingGame;
import carracing.car.RandomRange;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class RacingGameMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Car> inputCars = InputView.inputCars(scanner);
		Cars racingCars = new Cars(inputCars);

		RacingGame racingGame = new RacingGame(racingCars);
		MovingStrategy movingStrategy = new RandomRange(0, 9);
		int tryingTimes = InputView.inputTryingNumber(scanner);
		racingGame.race(movingStrategy, tryingTimes);

		ResultView.printResultPhrase();
		ResultView.printWinners(racingCars.winners(new MaxMoving()));
	}
}
