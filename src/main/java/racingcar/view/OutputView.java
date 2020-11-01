package racingcar.view;

import racingcar.Car;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final PrintStream out = System.out;
    private static final String DISTANCE_UNIT = "-";

    public void showResult(List<Car> cars) {
        String result = cars.stream()
                .map(this::carToString)
                .collect(Collectors.joining("\n"));

        out.println(result + "\n");
    }

    private String carToString(Car c) {
        return IntStream.range(0, c.getPosition())
                .mapToObj(i -> DISTANCE_UNIT)
                .collect(Collectors.joining());
    }
}
