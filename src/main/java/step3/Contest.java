package step3;

import java.util.List;

public class Contest {
    private final int round;
    private final List<Car> participants;

    public Contest(int round, List<Car> participants) {
        this.round = round;
        this.participants = participants;
    }

    public void play() {
        for (int i = 0; round > i; i++) {
            for (Car participant : participants) {
                participant.play(new InputMovingStrategy(4));
            }
        }
    }
}
