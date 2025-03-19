package racingcar;

import racingcar.movepolicy.DefaultMoveStrategy;
import racingcar.movepolicy.MoveStrategy;
import racingcar.racing.Car;
import racingcar.racing.Racing;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        OutputView.askCarNumbers();
        List<String> carNames = InputView.getCarNames(); // 첫 번째 값 입력받음

        OutputView.askRoundNumbers();
        int numberOfRounds = InputView.getNumberOfRounds(); // 두 번째 값 입력받음

        MoveStrategy moveStrategy = new DefaultMoveStrategy();

        List<Car> cars = carNames.stream()
                .map(name -> new Car(name, moveStrategy))
                .collect(Collectors.toList());

        Racing racing = new Racing(cars);

        OutputView.showRace(racing, numberOfRounds);
    }
}