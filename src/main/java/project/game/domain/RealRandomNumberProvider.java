package project.game.domain;

import java.util.Random;

public class RealRandomNumberProvider implements RandomNumberProvider {

    private Random mRandom;
    private int mRandomBound;

    public RealRandomNumberProvider(int randomBound) {
        this.mRandom = new Random();
        this.mRandomBound = randomBound;
    }

    @Override
    public int getRandomNumber() {
        return mRandom.nextInt(mRandomBound);
    }
}
