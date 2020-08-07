package step3;

import java.util.Random;

public class CarRacing {
	private static final int CAN_MOVE_NUM = 4;
	private static final String MOVE_MARK = "-";
	private static final Random random = new Random();

	public void showRaceResult() {
		int carCount = InputView.requestHowManyCar();
		int times = InputView.requestHowManyTimes();

		StringBuilder[] cars = getNewCars(carCount);
		StringBuilder[] raceResult = new StringBuilder[times];

		for (int i = 0; i < times; i++) {
			raceResult[i] = moveForward(cars);
		}

		ResultView.printResult(raceResult);
	}

	public static StringBuilder[] getNewCars(int carCount) {
		StringBuilder[] cars = new StringBuilder[carCount];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new StringBuilder();
		}
		return cars;
	}

	private static StringBuilder moveForward(StringBuilder[] cars) {
		StringBuilder roundResult = new StringBuilder();
		for (int i=0; i < cars.length; i++) {
			cars[i] = canMoveForward(cars[i]);
			roundResult.append(cars[i]).append("\n");
		}
		return roundResult;
	}

	public static StringBuilder canMoveForward(StringBuilder car) {
		if(random.nextInt(9) >= CAN_MOVE_NUM) {
			car.append(MOVE_MARK);
		}
		return car;
	}

}
