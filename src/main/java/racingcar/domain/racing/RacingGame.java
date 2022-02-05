package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Participants;
import racingcar.domain.car.Turn;
import racingcar.domain.random.RandomGenerator;
import racingcar.domain.random.MovementStrategy;

public class RacingGame {

    private static final MovementStrategy RANDOM_GENERATOR = new RandomGenerator();

    private final Turn turn;
    private Participants participants;

    public RacingGame(Participants participants, Turn turn) {
        this.participants = participants;
        this.turn = turn;
    }

    public List<Participants> start() {
        List<Participants> cars = new ArrayList<>();
        int turnCount = turn.getValue();

        for (int i = 0; i < turnCount; i++) {
            participants = participants.race(RANDOM_GENERATOR);
            cars.add(participants);
        }

        return new ArrayList<>(cars);
    }
}
