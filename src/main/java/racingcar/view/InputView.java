package racingcar.view;

import racingcar.race.RacingModel;

import java.util.Scanner;

public class InputView {

    public RacingModel printStartScreen(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return new RacingModel(numberOfCar, tryCount);
    }

}
