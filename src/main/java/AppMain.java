import racingcar.RacingGame;
import racingcar.ResultView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
            String cars = scanner.nextLine();

            System.out.println("시도할 회수는 몇 회 인가요?");
            int time = scanner.nextInt();

            RacingGame racingGame = new RacingGame(cars, time);
            ResultView resultView = racingGame.start();
            resultView.printResult();
            resultView.printRacingGameWinner();

        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력하세요");
        }
    }
}
