package carracinggame;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
	public void start(int carCount, int moveCount, ResultView resultView) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			carList.add(new Car(new RandomMoveStrategy()));
		}

		resultView.nextLine();
		resultView.printResultText();
		for (int i = 0; i < moveCount; i++) {
			startOneRound(carList, resultView);
		}
	}

	public void startOneRound(List<Car> carList, ResultView resultView) {
		for (Car car : carList) {
			car.move();
			resultView.printCarPosition(car.getPosition());
		}
		resultView.nextLine();
	}
}
