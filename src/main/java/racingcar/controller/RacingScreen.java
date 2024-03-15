package racingcar.controller;

import static java.text.MessageFormat.format;

import racingcar.util.StringSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.GameResult;

public class RacingScreen {

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String PLAYING_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String INVALID_INT_FORMAT_MESSAGE = "정수 형태의 숫자만 입력해주세요. [userInput : {0}]";
    private static final String UNEXPECTED_EXCEPTION_MESSAGE = "알 수 없는 오류가 발생했습니다.";

    private final InputView inputView;
    private final OutputView outputView;

    public RacingScreen(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int readCarCount() {
        return readIntInputWithMessage(CAR_COUNT_INPUT_MESSAGE);
    }

    public String[] readCarNames() {
        outputView.printOneLine(CAR_NAMES_INPUT_MESSAGE);
        final String userInput = inputView.readOneLine();

        return StringSplitter.split(userInput);
    }

    public int readPlayingCount() {
        return readIntInputWithMessage(PLAYING_COUNT_INPUT_MESSAGE);
    }

    private int readIntInputWithMessage(final String inputMessage) {
        String userInput = null;

        try {
            outputView.printOneLine(inputMessage);
            userInput = inputView.readOneLine();

            return Integer.parseInt(userInput);
        } catch (final NumberFormatException e) {
            throw new NumberFormatException(format(INVALID_INT_FORMAT_MESSAGE, userInput));
        }

    }

    public void printGameResult(final GameResult gameResult) {
        outputView.printOneLine(gameResult.toString());
    }

    public void printBusinessExceptionMessage(final String message) {
        outputView.printOneLine(message);
    }

    public void printUnexpectedExceptionMessage() {
        outputView.printOneLine(UNEXPECTED_EXCEPTION_MESSAGE);
    }
}
