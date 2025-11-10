package study.racing;

import study.racing.domain.RacingGame;
import study.racing.domain.RandomNumber;
import study.racing.view.GameInput;
import study.racing.view.GameOutput;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameInput gameInput = new GameInput(scanner);
        GameOutput gameOutput = new GameOutput();

        List<String> carNames = gameInput.readCarCount();
        int roundCount = gameInput.readRoundCount();
        RacingGame racingGame = new RacingGame(carNames, new RandomNumber());
        gameOutput.printResult();

        for (int i = 0; i < roundCount; i++) {
            racingGame.playRound();
            gameOutput.printRound(racingGame.getCars());
            gameOutput.printEmptyLine();
        }
        gameOutput.printWinners(racingGame.getWinners().getNames());
    }
}
