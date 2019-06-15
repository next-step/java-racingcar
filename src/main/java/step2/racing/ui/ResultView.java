package step2.racing.ui;

import step2.racing.model.Car;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private final PrintStream printStream;
    private static final String POSITION_MARK = "-";

    public ResultView(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void printEntireCarsPosition(List<Car> cars) {

        printNewLine();
        cars.forEach(this::printCarPosition);
    }

    private void printCarPosition(Car car) {

        IntStream.range(0, car.checkPosition())
                .forEach(i -> printPositionMark());
        printNewLine();
    }

    private void printPositionMark() {

        printStream.print(POSITION_MARK);
    }

    private void printNewLine() {

        printStream.println();
    }
}
