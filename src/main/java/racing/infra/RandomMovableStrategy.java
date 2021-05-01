package racing.infra;

import racing.domain.MovableStrategy;

public class RandomMovableStrategy implements MovableStrategy {
    private static final int MOVE_NUMBER = 4;

    private RandomNumberGenerator randomNumberGenerator;

    private RandomMovableStrategy(RandomNumberGenerator randomNumberGenerator){
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static RandomMovableStrategy of(RandomNumberGenerator randomNumberGenerator){
        return new RandomMovableStrategy(randomNumberGenerator);
    }

    @Override
    public boolean movable() {
        if(randomNumberGenerator.generate() >= MOVE_NUMBER) {
            return true;
        }
        return false;
    }
}