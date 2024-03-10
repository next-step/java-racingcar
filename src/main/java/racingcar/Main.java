package racingcar;

import racingcar.application.RacingCarGame;
import racingcar.domain.CarMoveGenerator;
import racingcar.domain.SixtyPercentAdvanceGenerator;
import racingcar.presentation.ConsoleRacingCarClient;
import racingcar.presentation.RacingCarClient;

public class Main {
    public static void main(String[] args) {
        final RacingCarClient racingCarClient = new ConsoleRacingCarClient();
        final CarMoveGenerator randomCarMoveGenerator = new SixtyPercentAdvanceGenerator();

        final RacingCarGame racingCarGame = new RacingCarGame(racingCarClient, randomCarMoveGenerator);
        racingCarGame.play();
    }
}
