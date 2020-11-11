package race.ui;

import race.logic.Car;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

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
        out.print(car.getName() + " : ");
        out.println(POSITION_MARKER.repeat(car.getCurrentPosition() + 1));
    }

    public void showStatus(List<Car> cars) {
        cars.forEach(this::showStatus);
        out.println();
    }

    public void showWinner(List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        out.println(winners + "가 최종 우승했습니다.");
    }
}
