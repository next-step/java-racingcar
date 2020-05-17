package racingCar.ui;

import racingCar.application.RacingGame;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public RacingGame setStartInput() {
        int carCount = getCarCount();
        int time = getTime();
        return new RacingGame(carCount, time);
    }

    private int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int getTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
