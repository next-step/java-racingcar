package racingCar.ui;

import racingCar.car.Car;
import racingCar.car.Cars;
import racingCar.car.Winners;

import java.util.List;

public class ConsoleResultView implements ResultView {
	@Override
	public void printPrefix() {
		System.out.println();
		System.out.println(ResultView.RESULT_PREFIX);
	}

	@Override
	public void printDistance(Cars cars) {
		List<Car> carList = cars.carList();
		for (Car car : carList) {
			System.out.println("-".repeat(car.distance));
		}
		System.out.println();
	}

	@Override
	public void printDistanceWithName(Cars cars) {
		List<Car> carList = cars.carList();
		for (Car car : carList) {
			System.out.print(car.carName + " : ");
			System.out.println("-".repeat(car.distance));
		}
		System.out.println();
	}

	@Override
	public void printWinner(Winners winners) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Car winner : winners.winners()) {
			stringBuilder.append(winner.carName);
			stringBuilder.append(", ");
		}
		stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
		stringBuilder.append("가 최종 우승했습니다.");
		System.out.println(stringBuilder);
	}
}
