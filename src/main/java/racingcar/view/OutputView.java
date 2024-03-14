package racingcar.view;

public interface OutputView {

    String CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    String PLAYING_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    void printOneLine(final String text);

    void printCarCountInputMessage();

    void printPlayingCountInputMessage();
}
