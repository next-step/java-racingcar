package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import racingCar.domain.Car;

public class RacingCarUI {

	public static final String HOW_MANY_ROUNDS = "시도할 회수는 몇 회 인가요?";

	public static final String WHAT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

	private static final Scanner sc = new Scanner(System.in);
	private static String DISTANCE_DASH = "-";

	private static String COLON = " : ";

	public static int uiForRoundInput() {
		System.out.println(HOW_MANY_ROUNDS);
		int round = Integer.parseInt(sc.nextLine());

		return round;
	}

	public static List<String> uiForCarNamesInput() {
		System.out.println(WHAT_CAR_NAMES);
		String input = sc.nextLine();

		List<String> carNames = Arrays.asList(input.split(",\\s*"));
		return carNames;
	}

	public static void printResult(List<Car> carList, List<Car> winners) {
		printCars(carList);

		printWinners(winners);
	}

	private static void printCars(List<Car> carList) {
		for (Car car : carList) {
			String name = car.getName();
			String distance = DISTANCE_DASH.repeat(car.getDistanceAmount());

			System.out.println(name + COLON + distance);
		}
	}

	private static void printWinners(List<Car> winners) {
		String winnerNames = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", "));

		System.out.println("최종 우승자: " + winnerNames);
	}
}
