package step3.view;

import step3.util.Constant;

import java.util.Scanner;

public class InputView {
    private static final String COUNT_OF_CARS_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String COUNT_OF_TRY_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String IMPOSSIBLE_INPUT_NUMBERS_LESS_THAN_ZERO = "0 이하의 숫자는 입력할 수 없습니다.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getCountOfCars() {
        System.out.println(COUNT_OF_CARS_INPUT_MESSAGE);
        int countOfCars = Integer.parseInt(scanner.nextLine());
        if (countOfCars <= Constant.ZERO) {
            throw new IllegalArgumentException(IMPOSSIBLE_INPUT_NUMBERS_LESS_THAN_ZERO);
        }
        return countOfCars;
    }

    public static int getCountOfTry() {
        System.out.println(COUNT_OF_TRY_INPUT_MESSAGE);
        int countOfTry = Integer.parseInt(scanner.nextLine());
        if (countOfTry <= Constant.ZERO) {
            throw new IllegalArgumentException(IMPOSSIBLE_INPUT_NUMBERS_LESS_THAN_ZERO);
        }
        return countOfTry;
    }
}
