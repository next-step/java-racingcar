package study.racingCar;

import java.util.Random;

public class RandomNumGenerator {

    public static int getRandomNum(){
        Random r = new Random();
        return r.nextInt(10);
    }
}
