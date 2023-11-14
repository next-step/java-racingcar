package racingCar.ui;

import racingCar.car.Cars;
import racingCar.car.Winners;

public interface ResultView {
	String RESULT_PREFIX = "실행 결과";

	void printPrefix();

	void printDistance(Cars cars);

	void printDistanceWithName(Cars cars);

	void printWinner(Winners winners);
}
