package study.racingCar;

import java.util.Random;

public class RacingModel {

    public RacingModel() {
    }

    public int randomNum(){
        Random random = new Random();
        return random.nextInt(10);
    }

}
