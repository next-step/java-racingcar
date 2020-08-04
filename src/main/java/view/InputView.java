package view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_OF_NUMBER_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TIME_NUMBER_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputNumberOfCar() {
        System.out.println(CAR_OF_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputTime() {
        System.out.println(TIME_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
