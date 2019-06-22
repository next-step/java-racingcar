package racingcar.view.result;

import racingcar.domain.RacingCars;


public interface ResultView {
    void printHeader();
    void printBody(RacingCars racingCars);
    void printFooter(RacingCars racingCars);
}
