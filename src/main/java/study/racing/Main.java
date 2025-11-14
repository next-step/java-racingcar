package study.racing;

import study.racing.domain.RacingGame;
import study.racing.domain.RandomNumber;
import study.racing.domain.RoundCount;
import study.racing.view.GameInput;
import study.racing.view.GameOutput;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = GameInput.readCarCount();
        RoundCount maxRoundCount = GameInput.readRoundCount();
        RacingGame racingGame = new RacingGame(carNames, maxRoundCount);
        GameOutput.printResult();

        while (racingGame.hasNextRound()) {
            racingGame.playRound(new RandomNumber());
            GameOutput.printRound(racingGame.getCars());
            GameOutput.printEmptyLine();
        }
        GameOutput.printWinners(racingGame.getWinners().getNames());
    }
}
