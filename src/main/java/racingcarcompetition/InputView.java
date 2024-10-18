package racingcarcompetition;

import java.util.Scanner;

public class InputView {

    public static Integer numberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static Integer movingTryCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
