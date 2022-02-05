package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Participants;
import racingcar.domain.car.Turn;
import racingcar.domain.random.MovementStrategy;

public class RacingGame {

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
}
