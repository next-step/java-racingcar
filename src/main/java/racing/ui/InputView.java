package racing.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대인가요?");

        return scanner.nextInt();
    }

    public static int inputNumberOfRounds() {
        System.out.println("시도할 회수는 몇 회인가요?");

        return scanner.nextInt();
    }
}
