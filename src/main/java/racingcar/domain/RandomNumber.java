package racingcar.domain;


import java.util.Random;

public class RandomNumber implements Randomable {

    private Random random;

    public RandomNumber() {
        this.random = new Random();
    }

    @Override
    public int getIntInRange(int min, int max) {
        return this.random.nextInt(max-min+1)+min;
    }

}
