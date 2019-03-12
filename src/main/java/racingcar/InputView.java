package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static int times;
    private static String[] names;

    public static void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            names = scanner.nextLine().split(",");
            System.out.println("시도할 회수는 몇 회 인가요?");
            times = scanner.nextInt();

            checkRaceCondition();
        } catch (InputMismatchException e) {
            System.out.println("자연수만 입력할 수 있습니다.");
        }
    }

    private static void checkRaceCondition() {
        if (names.length == 0)
            throw new RuntimeException("경주에는 최소 1대 이상의 자동차가 필요합니다.");
        if (times <= 0)
            throw new RuntimeException("시도할 회수는 자연수만 입력할 수 있습니다.");
    }

    public static String[] getNames() {
        return names;
    }

    public static int getTimes() {
        return times;
    }
}
