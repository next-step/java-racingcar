package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Participants;
import racingcar.domain.car.Turn;
import racingcar.domain.random.MovementStrategy;

public class RacingGame {

    private static final String DELIMITER = ", ";

    private final Turn turn;
    private Participants participants;
    private final MovementStrategy randomMovementStrategy;

    public RacingGame(Participants participants, Turn turn, MovementStrategy movementStrategy) {
        this.participants = participants;
        this.turn = turn;
        this.randomMovementStrategy = movementStrategy;
    }

    public List<Participants> start() {
        List<Participants> cars = new ArrayList<>();
        int turnCount = turn.getValue();

        for (int i = 0; i < turnCount; i++) {
            participants = participants.race(randomMovementStrategy);
            cars.add(participants);
        }

        return new ArrayList<>(cars);
    }

    public String findWinners(List<Participants> racingResult) {
        List<Car> cars = new ArrayList<>(finalResultOf(racingResult).getParticipants());
        Collections.sort(cars, (car1, car2) -> car2.getPosition() - car1.getPosition());

        String winners = cars.stream()
            .filter(car -> car.isSamePosition(cars.get(0)))
            .map(Car::getName)
            .collect(Collectors.joining(DELIMITER));

        return winners;
    }

    public Participants finalResultOf(List<Participants> racingResult) {
        return racingResult.get(racingResult.size() - 1);
    }
}
