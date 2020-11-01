package racingcar.view;

import racingcar.Car;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final PrintStream out = System.out;

    public void showResult(List<Car> cars) {
        String result = cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));

        out.println(result+"\n");
    }
}
