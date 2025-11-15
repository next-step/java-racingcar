package racingcar;

import java.util.Scanner;

import static racingcar.InputView.readCount;
import static racingcar.OutputView.printResults;

public class RacingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = readCount("자동차 대수는 몇 대 인가요?", scanner);
        int count = readCount("시도할 회수는 몇 회 인가요?", scanner);

        Racing racing = new Racing(number);
        printResults(count, racing);

        scanner.close();
    }
}
