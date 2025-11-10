package study.racing;

import study.racing.domain.RacingGame;
import study.racing.domain.RandomNumber;
import study.racing.view.GameInput;
import study.racing.view.GameOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameInput gameInput = new GameInput(scanner);
        GameOutput gameOutput = new GameOutput();

        int carCount = gameInput.readCarCount();
        int roundCount = gameInput.readRoundCount();
        //TODO 추후에 변경 임시값
        List<String> names = Arrays.asList("123", "432");
        RacingGame racingGame = new RacingGame(names, new RandomNumber());
        gameOutput.printResult();

        for (int i = 0; i < roundCount; i++) {
            racingGame.playRound();
            gameOutput.printRound(racingGame.getPositions());
            gameOutput.printEmptyLine();

        }
    }
}
