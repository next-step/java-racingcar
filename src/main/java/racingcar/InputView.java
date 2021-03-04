package racingcar;

import java.util.Scanner;

public class InputView {

    private static RacingGame racingGame = new RacingGame();
    private static Scanner scanner = new Scanner(System.in);

    public int inputCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int countCar = scanner.nextInt();

        return countCar;
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int countTry = scanner.nextInt();

        return countTry;
    }

    public void start() {
        int countCar = inputCarNumber();

        int countTry = inputTryCount();

        racingGame.startRacing(countCar, countTry);
    }
}
