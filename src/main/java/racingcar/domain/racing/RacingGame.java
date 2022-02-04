package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Participants;
import racingcar.domain.random.MovementGenerator;
import racingcar.domain.random.MovementStrategy;

public class RacingGame {

    private static final MovementStrategy RANDOM = new MovementGenerator();

    private final int turnCount;
    private Participants participants;

    public RacingGame(Participants participants, int turnCount) {
        this.participants = participants;
        this.turnCount = turnCount;
    }

    public List<Participants> gameStart() {
        List<Participants> cars = new ArrayList<>();

        for (int i = 0; i < turnCount; i++) {
            participants = participants.race(RANDOM);
            cars.add(participants);
        }

        return new ArrayList<>(cars);
    }
}
