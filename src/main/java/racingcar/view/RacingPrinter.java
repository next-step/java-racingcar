package racingcar.view;

import racingcar.vo.GameResult;

public interface RacingPrinter {

    void printGameResult(final GameResult result);

    void printBusinessExceptionMessage(final String message);

    void printServerExceptionMessage(final String message);

    void printUnexpectedExceptionMessage();
}
