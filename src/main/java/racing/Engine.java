package racing;

import java.util.Random;

public class Engine {
    Random random;

    public Engine() {
        this.random = new Random();
    }

    public boolean cycle() {
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber = " + randomNumber);
        return randomNumber >= 4;
    }
}
