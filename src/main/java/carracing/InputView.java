package carracing;

import java.util.Scanner;

public class InputView {

    private static InputView instance;
    private final Scanner SCANNER = new Scanner(System.in);

    public int requestCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextInt();
    }

    public int requestCarMovementCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }
}
