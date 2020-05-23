package racing.view;

import racing.util.Printer;

public class RacingView {

    public void print(final int[] cars) {
        for (int carLocation : cars) {
            printCarMovement(carLocation);
        }
        Printer.printBorder();
    }

    private void printCarMovement(final int location) {
        for (int i = 0; i < location; i++) {
            Printer.printMovement();
        }
        Printer.printBorder();
    }
}
