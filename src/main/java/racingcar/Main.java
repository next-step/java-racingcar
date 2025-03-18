package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        OutputView.askCarNumbers();
        int numberOfCars = InputView.getCarNames(); // 첫 번째 값 입력받음

        OutputView.askRoundNumbers();
        int numberOfRounds = InputView.getNumberOfRounds(); // 두 번째 값 입력받음

        MoveStrategy moveStrategy = new DefaultMoveStrategy();

        List<Car> cars = IntStream.range(0, numberOfCars)
                .mapToObj(i -> new Car(moveStrategy))
                .collect(Collectors.toList());

        Racing racing = new Racing(cars);

        OutputView.showRace(racing, numberOfRounds);
    }
}