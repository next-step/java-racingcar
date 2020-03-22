package racingcar.domain;

import lombok.Getter;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;

    private int time;
    @Getter
    private List<Car> cars;
    @Getter
    private List<CarRoundLog> roundLogs;
    private GameRole gameRole;

    public RacingGame(int time, List<Car> cars, GameRole gameRole) {
        this.time = time;
        this.cars = cars;
        this.gameRole = gameRole;
        this.roundLogs = new ArrayList<>();
    }

    public void start() {
        for (int i = 0; i < time; i++) {
            roundLogs.add(new CarRoundLog());
            moveCars(i);
        }
    }

    public List<Car> findWinner() {
        final int winnerPosition = findWinnerPosition();
        return cars.stream()
                .filter(car -> car.equalPosition(winnerPosition))
                .collect(Collectors.toList());
    }

    private int findWinnerPosition() {
        return cars.stream().max(Comparator.comparing(Car::getPosition)).get().getPosition();
    }

    private void moveCars(int round) {
        for (Car car : cars) {
            int advanceCount = gameRole.getAdvanceCount(RandomUtils.random(RANDOM_BOUND));

            car.move(advanceCount);

            roundLogs.get(round).addCarLogs(car.getName(), car.getPosition());
        }
    }
}
