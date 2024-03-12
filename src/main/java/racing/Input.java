package racing;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    Input() {
        this.scanner = new Scanner(System.in);
    }

    public int CarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int AttemptsNumber() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void close() {
        this.scanner.close();
    }
}
