package racingCar.view;

import racingCar.domain.Cars;
import racingCar.domain.Winners;

public interface ResultView {
	String RESULT_PREFIX = "실행 결과";

	void printPrefix();

	void printDistance(Cars cars);

	void printDistanceWithName(Cars cars);

	void printWinner(Winners winners);
}
