package racing.domain;

import racing.RandomNumber;

import java.util.Random;

public class RandomNumberGenerator implements RandomNumber {

    Random RANDOM = new Random();

    @Override
    public boolean movable() {
        if(RANDOM.nextInt(10) > 5){
            return true;
        }
        return false;
    }
}
