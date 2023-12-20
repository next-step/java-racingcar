package racingcar.ui;

import racingcar.model.Car;

import java.util.List;

public class UIInGame {
	public static void printCarNamesInput() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public static void printRoundInput() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
	}

	public static void printPosition(Integer round, List<Car> carList) {
		System.out.println("Round : " + round);
		for (int carNum = 0; carNum < carList.size(); carNum++) {
			System.out.println(carList.get(carNum).name() + " : " + "-".repeat(carList.get(carNum).distance()));
		}
		System.out.println();
	}
}
