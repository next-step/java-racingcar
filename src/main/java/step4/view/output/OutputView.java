package step4.view.output;

import step4.model.Cars;

public interface OutputView {
    void printRacingResult(final Cars cars);
    void printWinner(final String winners);
}
