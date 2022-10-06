package step4.view.output;

import step4.model.Cars;
import step4.model.Winners;

public interface OutputView {
    void printRacingResult(Cars cars);

    void printWinner(Winners winners);
}
