package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RaceInfo;
import racingcar.model.Race;
import racingcar.view.RaceInputView;
import racingcar.domain.Car;
import racingcar.domain.RaceInput;
import racingcar.view.RaceView;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private static final RaceView raceView = new RaceView();
    private static final RaceInputView raceInputView = new RaceInputView();
    private static final Race race = new Race();
    private static RaceInfo raceInfo;

    public static void main(String[] args) {
        RaceInput input = raceInputView.generateRaceInput();
        raceInfo = new RaceInfo(input);
        Cars cars = new Cars(input.getCarNames());
        doRace(cars);
        raceView.printWinners(cars);
    }

    public static void doRace(Cars cars) {
        while (raceInfo.raceAvailable()) {
            raceInfo.addCurrentRound();
            race.roundRace(cars);
            raceView.printCars(cars);
        }
    }
}
