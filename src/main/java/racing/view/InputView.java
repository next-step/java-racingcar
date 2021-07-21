package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_NUMBER_OF_COUNT = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static int inputNumberOfCar() {
        System.out.println(INPUT_NUMBER_OF_CAR);
        return getNextInt();
    }

    public static int inputNumberOfCount() {
        System.out.println(INPUT_NUMBER_OF_COUNT);
        return getNextInt();
    }

    private static int getNextInt() {
        return new Scanner(System.in).nextInt();
    }
}
