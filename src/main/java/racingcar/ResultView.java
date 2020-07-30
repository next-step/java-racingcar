package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final List<String> moveViews;

    public ResultView(List<Car> lacingCars) {
        moveViews = lacingCars.stream()
                .map(Car::toResultString)
                .collect(Collectors.toList());
    }

    public void printResult() {
        moveViews.forEach(System.out::println);
    }
}
