package racingcar;

import racingcar.application.RaceService;
import racingcar.domain.Car;
import racingcar.domain.RaceCommand;
import racingcar.view.ResultView;

import java.util.List;

import static racingcar.view.InputView.inputRaceCommand;

public class RacingCarApplication {
    public static void main(String[] args) {
        RaceCommand raceCommand = inputRaceCommand();
        int round = raceCommand.getTryCount();
        List<Car> cars = RaceService.startRace(Car.makeCarsBy(raceCommand.getCarCount()),
                                               round);
        ResultView.display(cars, round);
    }
}
