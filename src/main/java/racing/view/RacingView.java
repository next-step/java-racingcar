package racing.view;

import racing.domain.RacingResult;
import racing.util.Printer;

import java.util.List;

public class RacingView {

    public void print(final RacingResult racingResult) {
        for (int i = 0; i < racingResult.getRacingRoundSize(); i++) {
            printRoundResult(racingResult.getRoundResult(i));
        }
    }

    private void printRoundResult(final List<Integer> roundResult) {
        for (int carLocation : roundResult) {
            printCarMovement(carLocation);
        }
        Printer.printBorder();
    }

    private void printCarMovement(final int carLocation) {
        for (int i = 0; i < carLocation; i++) {
            Printer.printMovement();
        }
        Printer.printBorder();
    }
}
