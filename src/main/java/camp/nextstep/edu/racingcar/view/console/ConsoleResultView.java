package camp.nextstep.edu.racingcar.view.console;

import camp.nextstep.edu.racingcar.domain.CarName;
import camp.nextstep.edu.racingcar.domain.CarNames;
import camp.nextstep.edu.racingcar.domain.Rounds;
import camp.nextstep.edu.racingcar.view.OutputHandler;
import camp.nextstep.edu.racingcar.view.ResultView;
import camp.nextstep.edu.racingcar.view.formatter.Formatter;

import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ConsoleResultView implements ResultView {

    private static final String TITLE_GAME_RESULT = "실행 결과";
    private static final String POSTFIX_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String DELIMITER_GAME_RESULT = "\n";
    private static final String DELIMITER_WINNER = ", ";

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
        final CarNames winnerCarNames = rounds.getWinnersOfLastRound();
        final String winnerMessage = this.formatWinners(winnerCarNames);
        final String content = roundsFormatter.format(rounds);

        return new StringJoiner(DELIMITER_GAME_RESULT)
                .add(TITLE_GAME_RESULT)
                .add(content)
                .add(winnerMessage)
                .toString();
    }

    private String formatWinners(CarNames carNames) {
        final String formattedWinners = carNames.stream()
                .map(CarName::value)
                .collect(Collectors.joining(DELIMITER_WINNER));
        return formattedWinners + POSTFIX_WINNER_MESSAGE;
    }

}
