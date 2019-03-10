package racingcar;

import racingcar.vo.RacingGameParameter;

import java.util.Scanner;

public class RacingGameParameterInputView {
    public RacingGameParameter readRacingGameParameter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();
        System.out.println();

        scanner.close();

        return new RacingGameParameter(numberOfCar, tryCount);
    }
}
