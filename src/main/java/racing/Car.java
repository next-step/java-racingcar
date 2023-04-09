package racing;

import java.util.Random;

public class Car {

    public static int randomNumber(){
        Random random = new Random();
        return random.nextInt(10);
    }
}
