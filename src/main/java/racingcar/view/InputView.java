package racingcar;

import java.util.Map;
import java.util.Scanner;

public class InputView {

    private static RacingGame racingGame = new RacingGame();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int countCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int countRound = scanner.nextInt();

        racingGame.initRacing(countCar, countRound);

        resultView.printResult(racingGame.startRacing());
    }
}
