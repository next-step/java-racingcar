package racingcar.view;

import static racingcar.config.RacingCarException.INTEGER_FORMAT_INVALID;
import static racingcar.config.RacingCarException.UNEXPECTED_EXCEPTION;

import racingcar.util.StringSplitter;
import racingcar.view.io.Input;
import racingcar.view.io.Output;
import racingcar.view.util.ResultFormatter;
import racingcar.vo.GameResult;

public class RacingScreen implements RacingView {

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PLAYING_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String DELIMITER = ",";

    private final Input input;
    private final Output output;
    private final ResultFormatter resultFormatter;

    public RacingScreen(final Input input, final Output output, final ResultFormatter resultFormatter) {
        this.input = input;
        this.output = output;
        this.resultFormatter = resultFormatter;
    }

    @Override
    public String[] readCarNames() {
        final String userInput = readUserInput(CAR_NAMES_INPUT_MESSAGE);

        return StringSplitter.split(userInput, DELIMITER);
    }

    @Override
    public int readPlayingCount() {
        final String userInput = readUserInput(PLAYING_COUNT_INPUT_MESSAGE);

        try {
            return Integer.parseInt(userInput);
        } catch (final NumberFormatException e) {
            throw new NumberFormatException(INTEGER_FORMAT_INVALID.message(userInput));
        }
    }

    private String readUserInput(final String inputMessage) {
        output.printOneLine(inputMessage);

        return input.readOneLine();
    }

    @Override
    public void printGameResult(final GameResult gameResult) {
        final String gameResultView = resultFormatter.formatGameResult(gameResult);

        output.printOneLine(gameResultView);
    }

    @Override
    public void printBusinessExceptionMessage(final String message) {
        output.printOneLine(message);
    }

    @Override
    public void printServerExceptionMessage(final String message) {
        output.printOneLine(message);
    }

    @Override
    public void printUnexpectedExceptionMessage() {
        output.printOneLine(UNEXPECTED_EXCEPTION.message());
    }
}
