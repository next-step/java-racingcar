package racingcar.resultview;

import racingcar.domain.RacingCar;

import java.util.List;

public interface ResultView {
    void printProgress(List<RacingCar> cars);

    void printWinners(List<RacingCar> winners);
}
