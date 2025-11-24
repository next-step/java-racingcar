package racinggame;

import racinggame.domain.RacingGame;

import java.util.Scanner;

import static racinggame.view.InputView.*;
import static racinggame.view.OutputView.*;

public class RacingMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = readNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", scanner);
        int count = readCount("시도할 회수는 몇 회 인가요?", scanner);

        RacingGame racingGame = new RacingGame(names);
        printResults(count, racingGame);
        printWinners(racingGame);

        scanner.close();
    }
}
