package racingCar.UI;

import racingCar.Application.RacingGame;

import java.util.Scanner;

public class InputView {
    public RacingGame setStartInput() {
        Scanner scanner = new Scanner(System.in);
        int carCount = getCarCount(scanner);
        int time = getTime(scanner);
        return new RacingGame(carCount, time);
    }

    private int getCarCount(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int getTime(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
