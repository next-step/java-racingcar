package carrace;

import java.util.Random;

public class CarStarter {
	public static Random random = new Random();
	public static InputView inputView = new InputView();
	public static ResultView resultView = new ResultView();
	public static void main(String[] args) {
		int carCount = inputView.printAndGetCarCount();
		int moveCount = inputView.printAndGetMoveCount();

		Car[] carArray = new Car[carCount];
		for (int i = 0; i < carArray.length; i++) {
			carArray[i] = new Car();
		}
		resultView.nextLine();
		resultView.printResultText();
		for (int i = 0; i < moveCount; i++) {
			moveCars(carArray);
		}
	}

	public static void moveCars(Car[] carArray) {
		for (Car car : carArray) {
			resultView.printCarPosition(car.move(random.nextInt(10)));
		}
		resultView.nextLine();
	}
}
