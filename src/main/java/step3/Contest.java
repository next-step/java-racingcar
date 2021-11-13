package step3;

import step3.movingstrategy.MovingStrategy;

import java.util.List;

public class Contest {
    private final int round;
    private final List<Car> participants;
    private final MovingStrategy movingStrategy;

    public Contest(int round, List<Car> participants, MovingStrategy movingStrategy) {
        this.round = round;
        this.participants = participants;
        this.movingStrategy = movingStrategy;
    }

    public void play() {
        for (int i = 0; round > i; i++) {
            for (Car participant : participants) {
                participant.play(movingStrategy);
            }
        }
    }
}
