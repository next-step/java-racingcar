package step3;

import java.util.List;

public class RacingCarGameExecute {

    public static void main(String[] args) {
        RacingCarGameUi racingCarGameUi = new RacingCarGameUi();
        int carCount = racingCarGameUi.askRacingCarNumber();
        int attemptCount = racingCarGameUi.askAttemptNumber();

        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.ready(carCount, attemptCount);

        Attempt attempt = racingCarGame.getAttempt();
        racingCarGameUi.printExecuteResult();

        while (attempt.isEnd() == false) {
            racingCarGame.play();
            List<RacingCar> racingCarList = racingCarGame.getRacingCarList();
            racingCarGameUi.printRacingCar(racingCarList);
        }
    }
}
