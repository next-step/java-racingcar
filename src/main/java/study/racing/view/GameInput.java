package study.racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameInput {
    private final Scanner scanner;

    public GameInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readCarCount() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public int readRoundCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
