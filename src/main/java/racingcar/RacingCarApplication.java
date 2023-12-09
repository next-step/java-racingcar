package racingcar;

import racingcar.domain.Race;

import static racingcar.InputView.inputRace;

public class RacingCarApplication {
    public static void main(String[] args) {
        Race raceCommand = inputRace();
    }
}
