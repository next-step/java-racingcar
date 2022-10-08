package racingcar;

import java.util.Scanner;

public class InputView {
    private RacingModel racingModel;

    public void printStartScreen(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        racingModel = new RacingModel(numberOfCar, tryCount);
    }

    public RacingModel userInputRacingInfo() {
        return racingModel;
    }

}
