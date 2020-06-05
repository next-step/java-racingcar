package racing.view;

import racing.domain.Car;
import racing.domain.RacingResult;
import racing.domain.Winners;
import racing.util.Printer;

import java.util.List;

public class RacingView {

    public void print(final RacingResult racingResult) {
        for (int i = 1; i <= racingResult.getRacingRoundSize(); i++) {
            printRoundResult(racingResult.getRoundResult(i));
        }
        Printer.printWinner(Winners.getWinners(racingResult.getLastRoundResult()));
    }

    private void printRoundResult(final List<Car> roundResult) {
        for (Car car : roundResult) {
            Printer.printName(car.getName());
            printCarMovement(car.getLocation());
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
