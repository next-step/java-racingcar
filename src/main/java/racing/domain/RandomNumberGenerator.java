package racing.domain;

import racing.RandomNumber;

import java.util.Random;

public class RandomNumberGenerator implements RandomNumber {

    private final int FORWARD_COUNT = 4;
    private final Random RANDOM = new Random();

    @Override
    public boolean movable() {
        if(RANDOM.nextInt(10) >= FORWARD_COUNT){
            return true;
        }
        return false;
    }
}
