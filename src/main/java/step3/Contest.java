package step3;

import step3.movingstrategy.MovingStrategy;

import java.util.List;

public class Contest {
    private final int round;
    private final List<Car> participants;
    private final MovingStrategy movingStrategy;

    public Contest(int round, List<Car> participants, MovingStrategy movingStrategy) {
        assert participants != null;
        assert movingStrategy != null;
        this.round = round;
        this.participants = participants;
        this.movingStrategy = movingStrategy;
    }

    public void play() {
        for (int i = 0; round > i; i++) {
            playEachRound();
            reportCurrentScore();
        }
    }

    private void playEachRound() {
        for (Car participant : participants) {
            participant.play(movingStrategy);
        }
    }

    private void reportCurrentScore() {
        participants.forEach((car) ->
                System.out.println(new String(new char[car.location + 1]).replace("\0", "-"))
        );
        System.out.println();
    }
}
