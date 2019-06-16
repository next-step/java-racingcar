package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.domain.Rounds;
import camp.nextstep.edu.racingcar.view.OutputHandler;
import camp.nextstep.edu.racingcar.view.ResultView;
import camp.nextstep.edu.racingcar.view.formatter.Formatter;

public class ConsoleResultView implements ResultView {

    private static final String TITLE_GAME_RESULT = "실행 결과";
    private static final String DELIMITER_GAME_RESULT = "\n";

    private final OutputHandler<String> outputHandler;
    private final Formatter<Rounds> roundsFormatter;

    public ConsoleResultView(OutputHandler<String> outputHandler,
                             Formatter<Rounds> roundsFormatter) {
        this.outputHandler = outputHandler;
        this.roundsFormatter = roundsFormatter;
    }

    @Override
    public void print(Rounds rounds) {
        final String result = this.formatGameResult(rounds);
        outputHandler.handle(result);
    }

    private String formatGameResult(Rounds rounds) {
        final String content = roundsFormatter.format(rounds);
        return TITLE_GAME_RESULT + DELIMITER_GAME_RESULT + content;
    }

}
