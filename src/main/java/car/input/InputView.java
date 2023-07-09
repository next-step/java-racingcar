package car.input;

import java.util.Scanner;

public final class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_RACE_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String enterCarName() {
        System.out.println(INPUT_RACE_CAR_MESSAGE);
        try {
            return scanner.nextLine();
        } catch (RuntimeException e) {
            System.out.println("자동차 이름이 잘 못 되었습니다");
            return enterCarName();
        }
    }

    public static int enterCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        try {
            return scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("입력이 잘 못 되었습니다");
            return enterCount();
        }
    }
}
