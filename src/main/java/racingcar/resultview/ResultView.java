package racingcar.resultview;

import racingcar.domain.RacingCar;

import java.util.List;

public interface ResultView {
    void print(List<RacingCar> cars);
}
