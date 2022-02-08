package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingCarInput {

    private static Scanner scanner = new Scanner(System.in);

    private RacingCarInput() {
    }

    public static List<String> getCarName() {
        String input = "";
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        try {
            input = scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getCarName();
        }
        return Arrays.asList(input.split(","));
    }

    public static int getRaceCount() {
        String input = "";
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            input = scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getRaceCount();
        }
        return Integer.parseInt(input);
    }
}
