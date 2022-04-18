package racingcar.module;

public class InputView {
    private static final String INSERT_CAR_COUNT_PHRASE = "자동차 대수는 몇 대 인가요?";
    private static final String INSERT_RACE_COUNT_PHRASE = "시도할 회수는 몇 회 인가요?";

    public static void showInsertCarCountPhrase() {
        System.out.println(INSERT_CAR_COUNT_PHRASE);
    }

    public static void showInsertRaceCountPhrase() {
        System.out.println(INSERT_RACE_COUNT_PHRASE);
    }
}
