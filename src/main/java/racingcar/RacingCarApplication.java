package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RaceCommand;
import racingcar.view.ResultView;

import static racingcar.view.InputView.inputRaceCommand;

public class RacingCarApplication {
    public static void main(String[] args) {
        RaceCommand raceCommand = inputRaceCommand();
        ResultView.startAndDisplay(Car.makeCarsBy(raceCommand.getCarCount()),
                                   raceCommand.getTryCount());
    }
}
