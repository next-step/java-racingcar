package carracinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {
	public void start(String carNames, int moveCount, ResultView resultView) {
		String[] carNamesArray = carNames.split(",");
		List<Car> carList = new ArrayList<>();
		for (String carName : carNamesArray) {
			carList.add(new Car(carName, new RandomMoveStrategy()));
		}

		resultView.nextLine();
		resultView.printResultText();
		for (int i = 0; i < moveCount; i++) {
			startOneRound(carList, resultView);
		}

		resultView.printWinnerNames(getWinnerNames(carList));
	}

	public void startOneRound(List<Car> carList, ResultView resultView) {
		for (Car car : carList) {
			car.move();
			resultView.printCarInfo(car);
		}
		resultView.nextLine();
	}

	public String getWinnerNames(List<Car> carList) {
		int maxPosition = getMaxPosition(carList);
		return 	carList.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.joining(","));
	}

	private int getMaxPosition(List<Car> carList) {
		int maxPosition = 0;
		for (Car car : carList) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}
}
