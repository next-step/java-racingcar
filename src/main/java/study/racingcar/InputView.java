package study.racingcar;

import java.util.Scanner;

public class InputView {
    public static RacingGameVo getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        return new RacingGameVo(numberOfCar, time);
    }
}
