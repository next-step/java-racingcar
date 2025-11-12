package study.racing.view;

import study.racing.domain.RoundCount;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readCarCount() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static RoundCount readRoundCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return new RoundCount(scanner.nextInt());
    }
}
