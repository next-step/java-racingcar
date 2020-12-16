package racingcar.view;

import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Position;

public class ResultView {
	private static final String COMMA = ", ";
	private static final String POSITION_SIGN = "-";

	public static void printResult(Cars cars) {
		cars.getCars()
			.forEach(ResultView::printResult);

		System.out.println();
	}

	public static void printWinners(Cars cars) {
		String winners = cars.findWinners()
			.stream()
			.map(Car::getName)
			.map(Name::getName)
			.collect(Collectors.joining(COMMA));

		System.out.println(winners + "가 최종 우승했습니다.");
	}

	private static void printResult(Car car) {
		printResult(car.getName());
		printResult(car.getPosition());
		System.out.println();
	}

	private static void printResult(Name name) {
		System.out.print(name.getName() + " : ");
	}

	private static void printResult(Position position) {
		printResult(position.getPosition());
	}

	private static void printResult(Integer result) {
		for (int i = 0; i < result; i++) {
			System.out.print(POSITION_SIGN);
		}
	}
}
