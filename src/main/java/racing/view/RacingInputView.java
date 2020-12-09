package racing.view;

public class RacingInputView {
    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_TIMES = "시도할 회수는 몇 회 인가요?";


    public static void carNamesMessage() {
        System.out.println(CAR_NAMES_MESSAGE);
    }

    public static void tryTimesMessage() {
        System.out.println(TRY_TIMES);
    }
}
