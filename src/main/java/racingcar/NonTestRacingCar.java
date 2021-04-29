package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NonTestRacingCar {

    RacingCar racingCar = new RacingCar();

    public int createRandomNumber(){
        int number = 0;
        Random random = new Random();
        number = random.nextInt(9);
        return number;
    }

}
