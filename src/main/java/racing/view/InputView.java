package racing.view;

public class InputView {
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수를 입력해 주세요.";
    private static final String CAR_NAMES_INPUT_MESSAGE = "차이름을 입력해 주세요(쉽표(,)를 기준으로 구분)";

    public static int getTryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        return Console.readInteger();
    }

    public static String getCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        return Console.readLine();
    }
}
