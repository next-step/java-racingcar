package racingcar.view;

import calculator.domain.StringCalculator;
import racingcar.domain.Cars;
import racingcar.domain.Count;

import java.util.Scanner;

public class RacingCarInputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String NO_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Cars getCars() {
        try {
            System.out.println(INPUT_CAR_COUNT_MESSAGE);
            int carCount = parseNumber(SCANNER.nextLine());
            return new Cars(carCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    public static Count getCount() {
        try {
            System.out.println(INPUT_TRY_COUNT_MESSAGE);
            int tryCount = parseNumber(SCANNER.nextLine());
            return new Count(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCount();
        }
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_NUMBER_MESSAGE);
        }
    }
}
