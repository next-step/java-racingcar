package racing.ui;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static int inputNumberOfCars() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대인가요?");
        int unit = scanner.nextInt();

        return unit;
    }

    public static int inputNumberOfRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회인가요?");
        int round = scanner.nextInt();

        return round;
    }
}
