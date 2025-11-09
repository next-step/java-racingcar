package study.racing;

import java.util.Scanner;

public class GameInput {
    private final Scanner scanner;

    public GameInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int readRoundCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
