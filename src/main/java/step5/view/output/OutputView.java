package step5.view.output;

import step5.model.Cars;

public interface OutputView {
    void printRacingResult(final Cars cars);

    void printWinner(final String winners);
}
