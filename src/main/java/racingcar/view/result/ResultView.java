package racingcar.view.result;

import racingcar.domain.RacingCar;
import racingcar.domain.Winners;

import java.util.List;


public interface ResultView {
    void printHeader();
    void printBody(List<RacingCar> racingCars);
    void printFooter(Winners winners);
}
