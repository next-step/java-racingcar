package racingcar.view;

import racingcar.domain.Cars;

public class Result {
	private final String MOVE_PRINT = "-";
	private Cars cars;

	public Result(Cars cars) {
		this.cars = cars;
	}

	public void print() {
		cars.getCarsMove()
			.forEach(move -> System.out.println(MOVE_PRINT.repeat(move)));
		System.out.println();
	}
}
