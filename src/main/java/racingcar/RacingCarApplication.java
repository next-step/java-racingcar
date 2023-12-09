package racingcar;

import racingcar.application.RaceService;
import racingcar.domain.Race;

import static racingcar.view.InputView.inputRace;

public class RacingCarApplication {
    public static void main(String[] args) {
        Race race = inputRace();
        RaceService.startRace(race.getCarCount(), race.getTryCount());
    }
}
