import calculator.Calculator;
import racingcar.RacingGame;
import racingcar.ResultView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("자동차 대수는 몇 대 인가요?");
            int carCount = scanner.nextInt();

            System.out.println("시도할 회수는 몇 회 인가요?");
            int time = scanner.nextInt();

            RacingGame racingGame = new RacingGame(carCount, time);
            ResultView resultView = racingGame.start();
            resultView.printResult();

        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력하세요");
        }
    }
}
