package step3;

import java.util.Scanner;

public final class InputView {

    private final static Scanner scanner = new Scanner(System.in);
    private InputView() {}

    public static InputView of() {
        return new InputView();
    }

    public int getCountOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int getTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
