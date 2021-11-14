package racing.basic.domain;

import java.util.Random;

public class CarRacingGame {

    private Random random;

    public CarRacingGame(Random random) {
        this.random = random;
    }

    public void nextRound(int[] track) {
        for (int i = 0; i < track.length; i++) {
            track[i] += moveOrStop(random.nextInt());
        }
    }

    protected int moveOrStop(int percentage) {
        if(4 <= percentage) {
            return 1;
        }
        return 0;
    }
}
