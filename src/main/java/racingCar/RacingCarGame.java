package racingCar;

import java.util.List;

import static racingCar.RacingCar.getCarList;
import static racingCar.RacingCar.move;

public class RacingCarGame {
	public static void main(String[] args) {
		InputView inputView = new InputView();

		int carCount = inputView.carCount;
		int tryCount = inputView.tryCount;

		List<Car> carList = game(carCount, tryCount);

		new ResultView(carList, tryCount);
	}

	private static List<Car> game(int carCount, int tryCount) {
		List<Car> carList = getCarList(carCount);
		move(tryCount, carList);

		return carList;
	}
}
