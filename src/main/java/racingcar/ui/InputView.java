package racingcar.ui;

import java.util.Scanner;

public class InputView {

    public static int inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return getUserInput();
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return getUserInput();
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
