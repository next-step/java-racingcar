package racingcar.ui;

import racingcar.model.Car;

import java.util.List;

public final class UIInGame {
	public static void printCarNamesInput() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public static void printRoundInput() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
	}

	public static void printPosition(final Integer round, final List<Car> carList) {
		System.out.println("Round : " + round);
		for (Car car : carList) {
			System.out.println(car.name() + " : " + "-".repeat(car.distance()));
		}
		System.out.println();
	}
}
