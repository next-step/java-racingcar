package racingcar.ui;

import racingcar.model.Car;

import java.util.Map;

public class UIInGame {
	public static void printCarCountInput() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public static void printRoundInput() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
	}

	public static void printPosition(Integer round, Map<Integer, Car> carList) {
		System.out.println("Round : " + round);
		for (int carNum = 1; carNum <= carList.size(); carNum++) {
			System.out.print(carList.get(carNum).getName() + " : ");
			for (int i = 0; i < carList.get(carNum).getDistance(); i++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}
}
