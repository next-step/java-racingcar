package racingcar;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static RacingGameOption inputRacingGameOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTimes = scanner.nextInt();

        return new RacingGameOption(numberOfCar, numberOfTimes);
    }
}
