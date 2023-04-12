package domain;

import io.InputView;
import io.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final InputView inputView;
    private final ResultView resultView;
    public RacingCarGame(InputView inputView, List<Car> cars) {
        this.inputView = inputView;
        this.resultView = new ResultView(cars);
    }
    public ResultView move() {
        for (Car car : resultView.getCars()) {
            car.move();
        }
        return resultView;
    }

    public List<String> findWinner() {
        int maxScore = findMaxScore();
        return resultView.getCars()
                .stream().filter(
                        car -> car.getDistance() == maxScore
                )
                .map(Car::getOwner)
                .collect(Collectors.toList());
    }

    private int findMaxScore() {
        return resultView.getCars().stream().mapToInt(Car::getDistance).max().orElse(0);
    }

    public InputView getInputView() {
        return inputView;
    }
}
