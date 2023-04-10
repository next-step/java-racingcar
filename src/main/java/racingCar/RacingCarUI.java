package racingCar;

import java.util.List;

import racingCar.domain.Car;

public class RacingCarUI {

	public static final String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
	public static final String HOW_MANY_ROUNDS = "시도할 회수는 몇 회 인가요?";

	public static void printReadyStep1() {
		System.out.println(HOW_MANY_CARS);
	}

	public static void printReadyStep2() {
		System.out.println(HOW_MANY_ROUNDS);
	}

	public static void printResult(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getMileageView());
		}
	}
}
