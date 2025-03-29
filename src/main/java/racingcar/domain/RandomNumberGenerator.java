package racingcar.domain;


import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    public int generate() {
        Random random = new Random();
        return random.nextInt();
    }
}
