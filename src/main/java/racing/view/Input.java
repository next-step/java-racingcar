package racing.view;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public int inputAttempts(String inputAsk) {
        System.out.println(inputAsk);
        int attempts = scanner.nextInt();

        if (attempts < 0) {
            throw new IllegalArgumentException("시도할 횟수는 음수가 될 수 없습니다.");
        }

        return attempts;
    }

    public String inputCarNames(String inputAsk) {
        System.out.println(inputAsk);
        return scanner.nextLine();
    }

    public void close() {
        this.scanner.close();
    }
}
