package racing;

import java.util.Random;

public interface RandomNumberGenerator {

    Random RANDOM = new Random();
    default int randomNumber() {
        return RANDOM.nextInt(10);
    }
}