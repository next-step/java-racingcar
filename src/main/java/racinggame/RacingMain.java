package racinggame;

import racinggame.domain.RacingGame;

import java.util.Scanner;

import static racinggame.view.InputView.*;
import static racinggame.view.OutputView.*;


public class RacingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = readCount("자동차 대수는 몇 대 인가요?", scanner);
        int count = readCount("시도할 회수는 몇 회 인가요?", scanner);

        RacingGame racingGame = new RacingGame(number);
        printResults(count, racingGame);

        scanner.close();
    }
}
