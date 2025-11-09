package study.racing;

import study.racing.domain.RacingGame;
import study.racing.domain.RandomNumber;
import study.racing.view.GameInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameInput gameInput = new GameInput(scanner);

        int carCount = gameInput.readCarCount();
        int roundCount = gameInput.readRoundCount();
        RacingGame racingGame = new RacingGame(carCount, roundCount, new RandomNumber());
        racingGame.play();
    }
}
