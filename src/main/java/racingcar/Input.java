package racingcar;

import java.util.Scanner;

public class Input {
    private static int times;
    private static String[] names;

    static void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            names = scanner.nextLine().split(",");
            System.out.println("시도할 회수는 몇 회 인가요?");
            times = scanner.nextInt();
        }
    }

    public static String[] getNames() {
        return names;
    }

    public static int getTimes() {
        return times;
    }
}
