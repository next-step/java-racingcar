package study.step5.view;

import study.step5.domain.car.Cars;

public class OutputView {
	private static final String REPEATER = "-";        // 반복할 문자

	public void printRacingGame(Cars cars) {
		System.out.println("실행결과");
		cars.forEach(car ->
			System.out.println(car.getName() + " : " + REPEATER.repeat(car.getPosition())));
		System.out.println();
	}

	public void printWinners(Cars cars) {
		System.out.print(cars.getNames());
		System.out.println("가 최종 우승했습니다.");
	}
}
