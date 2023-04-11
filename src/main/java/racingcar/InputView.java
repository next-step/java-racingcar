package racingcar;

public class InputView {

    private static final String CARS_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 번 인가요?";

    public static void printCarsCountInputMessage() {
        System.out.println(CARS_COUNT_INPUT_MESSAGE);
    }

    public static void printTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }
}
