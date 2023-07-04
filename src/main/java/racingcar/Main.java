package racingcar;

import static racingcar.InputManager.readCarNames;
import static racingcar.InputManager.readRound;

public class Main {
    public static void main(String[] args) {
        RacingManager racingManager = RacingManager.of(readCarNames(), readRound());
        racingManager.playRacing();
    }
}
