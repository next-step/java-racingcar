package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static int inputNumberOfCars() {
        return inputNumber("자동차 대수는 몇 대 인가요?");
    }

    public static int inputNumberOfTries() {
        return inputNumber("시도할 회수는 몇 회 인가요?");
    }

    private static int inputNumber(String outputMessage) {
        System.out.println(outputMessage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
