package step3.ui;

import step3.logic.Car;

import java.io.PrintStream;
import java.util.List;

public class OutputView {
    private static final String POSITION_MARKER = "-";

    protected final PrintStream out;

    public OutputView() {
        this(System.out);
    }

    public OutputView(PrintStream out) {
        this.out = out;
    }

    public void showStatus(Car car) {
        out.println(POSITION_MARKER.repeat(car.getCurrentPosition() + 1));
    }

    public void showStatus(List<Car> cars) {
        cars.forEach(this::showStatus);
        out.println();
    }
}
