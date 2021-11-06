package racingStep3;

import java.util.Random;

public class RacingService {

    public int getRandom() {
        Random random = new Random();
        return random.nextInt(9);
    }


}
