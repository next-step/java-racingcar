package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getCarCount() {
        return getValidateInput("자동차 대수는 몇 대 인가요?\n");
    }

    public static int getTryCount() {
        return getValidateInput("시도할 회수는 몇 회 인가요?\n");
    }

    public static int getMaxRandomNumber() {
        return getValidateInput("자동차 전진 최대 값은 몇 인가요?\n");
    }

    private static int getValidateInput(String message) {
        System.out.println(message);
        while (true) {
            try {
                int number = getRandomNumber();
                if (number < 0) {
                    System.out.println("음수는 입력할 수 없습니다. 다시 입력해주세요.");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private static int getRandomNumber() {
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
