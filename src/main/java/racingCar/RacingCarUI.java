package racingCar;

import java.util.List;
import java.util.Scanner;

import racingCar.domain.Car;

public class RacingCarUI {

	public static final String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";

	public static final String HOW_MANY_ROUNDS = "시도할 회수는 몇 회 인가요?";

	private static final Scanner sc = new Scanner(System.in);


	public static int uiForCountInput() {
		System.out.println(HOW_MANY_CARS);
		int count = Integer.parseInt(sc.nextLine());

		return count;
	}

	public static int uiForRoundInput() {
		System.out.println(HOW_MANY_ROUNDS);
		int round = Integer.parseInt(sc.nextLine());

		return round;
	}

	public static void printResult(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getDistanceView());
		}
	}
}
