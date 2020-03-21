package racingcar.domain;

import racingcar.utils.RandomUtils;
import racingcar.view.ResultView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;

    private int time;
    private List<Car> cars;
    private GameRole gameRole;

    public RacingGame(int time, List<Car> cars, GameRole gameRole) {
        this.time = time;
        this.cars = cars;
        this.gameRole = gameRole;
    }

    public void start() {
        for (int i = 0; i < time; i++) {
            moveCars();
        }
    }

    public List<Car> findWinner() {
        final int winnerPosition = findWinnerPosition();
        return cars.stream()
                .filter(it -> it.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    private int findWinnerPosition() {
        return cars.stream().max(Comparator.comparing(Car::getPosition)).get().getPosition();
    }

    private void moveCars() {
        for (Car car : cars) {
            int advanceCount = gameRole.getAdvanceCount(RandomUtils.random(RANDOM_BOUND));

            car.move(advanceCount);
            car.printPosition();
        }

        ResultView.printNewLine();
    }
}
