package racingcar.view;

public class InputView {

    private static final String CARS_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 번 인가요?";

    public static void printCarsNamesInputMessage() {
        System.out.println(CARS_NAMES_INPUT_MESSAGE);
    }
    public static void printTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }
}
