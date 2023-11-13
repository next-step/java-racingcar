package racingCar.ui;

import racingCar.car.Cars;

public interface ResultView {
	String RESULT_PREFIX = "실행 결과";

	void printPrefix();

	void printDistance(Cars cars);
}
