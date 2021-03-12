package step3;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int enterCarCount() {
        System.out.println(ViewConstant.ENTER_CAR_COUNT);
        return scanner.nextInt();
    }

    public int enterRoundCount() {
        System.out.println(ViewConstant.ENTER_ROUND_COUNT);
        return scanner.nextInt();
    }
}