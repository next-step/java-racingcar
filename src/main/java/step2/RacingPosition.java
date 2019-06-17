package step2;

import java.util.Random;

public class RacingPosition {

    int carPositionSatatus(){
        Random generator = new Random();
        return generator.nextInt(10);
    }

    int carPositionUpdateValue(int randomNumber) {
        if (randomNumber < 4) {
            return 0;
        }
        return 1;
    }

}
