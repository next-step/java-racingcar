package study.racingCar;

import java.util.Random;

public class RandomNumGenerator {

    public RandomNumGenerator() {
    }

    public int randomNum(){
        Random random = new Random();
        return random.nextInt(10);
    }

}
