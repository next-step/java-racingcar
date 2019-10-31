package project.game.domain;

import java.util.Random;

public class RandomNumberProviderImpl implements RandomNumberProvider {

    private Random mRandom;
    private int mRandomBound;

    public RandomNumberProviderImpl(int randomBound) {
        this.mRandom = new Random();
        this.mRandomBound = randomBound;
    }

    @Override
    public int getRandomNumber() {
        return mRandom.nextInt(mRandomBound);
    }
}
