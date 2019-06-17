package carRacing;

import java.util.Random;

public class RandomEngine implements Engine{

    private Random random;

    public RandomEngine() {
        this.random = new Random();
    }

    @Override
    public int getPowerOutput() {
        return this.random.nextInt(10);
    }
}
