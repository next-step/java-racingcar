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
        RoundCount roundCount = GameInput.readRoundCount();
        RacingGame racingGame = new RacingGame(carNames, new RandomNumber());
        GameOutput.printResult();

        for (int i = 0; i < roundCount.getValue(); i++) {
            racingGame.playRound();
            GameOutput.printRound(racingGame.getCars());
            GameOutput.printEmptyLine();
        }
        GameOutput.printWinners(racingGame.getWinners().getNames());
    }
}
