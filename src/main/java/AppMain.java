import calculator.Calculator;
import racingcar.RacingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {

        try {
            int carCount = inputCarCountCondition();
            int time = inputTimeCondition();
            RacingGame racingGame = new RacingGame(carCount, time);
            racingGame.start();
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력하세요");
        }
    }

    private static int inputCarCountCondition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        return carCount;
    }

    private static int inputTimeCondition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();
        return time;
    }


}
