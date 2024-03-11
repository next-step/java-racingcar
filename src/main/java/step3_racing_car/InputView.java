package step3_racing_car;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> scanCarNames() {
        return List.of(scanStringInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").split(","));
    }

    public static int scanRoundCount() {
        return scanIntInput("시도할 횟수는 몇 회 인가요?");
    }

    private static int scanIntInput(String x) {
        System.out.println(x);
        int participantCarCount = scanner.nextInt();
        return participantCarCount;
    }

    private static String scanStringInput(String x) {
        System.out.println(x);
        String participantCarCount = scanner.nextLine();
        return participantCarCount;
    }
}
