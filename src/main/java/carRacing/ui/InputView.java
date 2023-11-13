package carRacing.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String PATTERN = ",";

    private InputView() {
    }

    public static String[] inputCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String text = SCANNER.next();
        return splitInput(havePattern(text));

    }

    public static int inputRound() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return isPositive(isNumber());
    }

    private static int isPositive(int number) {
        if (number > 1) {
            return number;
        }

        throw new InputMismatchException("1 이상의 양수를 입력해 주세요");
    }

    private static int isNumber() {
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException error) {
            throw new InputMismatchException("정수를 입력해주세요.");
        }
    }

    private static String havePattern(String text) {
        if (text.contains(PATTERN)) {
            return text;
        }
        throw new InputMismatchException("한대 이상의 자동차를 입력하여야 합니다.");
    }

    private static String[] splitInput(String text) {
        return text.split(PATTERN);
    }


}
