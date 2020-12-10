package carracinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingGame {
	public static Random random = new Random();
	public static InputView inputView = new InputView();
	public static ResultView resultView = new ResultView();
	public static void main(String[] args) {
		int carCount = inputView.printAndGetCarCount();
		int moveCount = inputView.printAndGetMoveCount();

		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			carList.add(new Car(new CarMoveStrategy()));
		}

		resultView.nextLine();
		resultView.printResultText();
		for (int i = 0; i < moveCount; i++) {
			startCarRacing(carList);
		}
	}

	public static void startCarRacing(List<Car> carList) {
		for (Car car : carList) {
			car.move(random.nextInt(10));
			resultView.printCarPosition(car.getPosition());
		}
		resultView.nextLine();
	}
}
