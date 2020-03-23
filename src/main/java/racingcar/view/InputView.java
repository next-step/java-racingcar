package racingcar.view;

import racingcar.util.Delimeters;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);
    private static int input;

    public static String[] insertCar() {
        message("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = split(sc.nextLine());
        return carNames;
    }

    private static String[] split(String input) {
        return input.split(Delimeters.COMMA);
    }

    public static int insertMoveCount() {
        message("시도할 회수는 몇 회 인가요?");
        return checkNumberValidation();
    }

    private static int checkNumberValidation() {
        try {
            input = checkNumber(sc.nextInt());
        } catch (InputMismatchException e) {
            message("숫자만 입력가능합니다.");
            e.printStackTrace();
            inputClose();
        }
        return input;
    }

    private static int checkNumber(int input) {
        if (input < 1) {
            message("1보다 큰 숫자를 입력해 주세요.\n");
            insertCar();
        }
        return input;
    }

    private static void message(String message) {
        System.out.println(message);
    }

    public static void inputClose() {
        sc.close();
    }
}
