package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> getCarNames() {
        printIntroMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.asList(getUserStringInput().split(","));
    }

    public static int getRoundNumber() {
        printIntroMessage("시도할 회수는 몇 회인가요?");
        return getUserIntegerInput();
    }

    private static int getUserIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String getUserStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static void printIntroMessage(String message) {
        System.out.println(message);
    }
}
