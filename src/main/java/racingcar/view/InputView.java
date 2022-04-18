package racingcar.view;

import racingcar.exception.InputException;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class InputView {
    private static final String CAR_INPUT_LABEL = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String ROUND_INPUT_LABEL = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String inputCarsInfo() {
        System.out.println(CAR_INPUT_LABEL);
        try {
            return SCANNER.nextLine();
        } catch (NoSuchElementException e) {
            throw new InputException("자동차 이름 입력이 잘못되었습니다. ");
        }
    }

    public static int inputRound() {
        System.out.println(ROUND_INPUT_LABEL);
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new InputException("시도 횟수 입력이 잘못되었습니다. 올바른 숫자를 입력해주세요. ");
        }
    }
}
