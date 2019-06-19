package racingcar.view.result;

import racingcar.model.RacingCars;


public interface ResultView {
    void printHeader();
    void printBody(RacingCars racingCars);
    void printFooter(RacingCars racingCars);
}
