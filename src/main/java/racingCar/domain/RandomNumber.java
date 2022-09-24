package racingCar.domain;


import java.util.Random;

public class RandomNumber {

    private int min;
    private int max;
    private Random random;

    public RandomNumber(int min, int max) {
        this.min = min;
        this.max = max;
        this.random = new Random();
    }

    public int nextInt() {
        return this.random.nextInt(this.max-min+1)+this.min;
    }

    public int max(){
        return max;
    }
    public int min(){
        return min;
    }
}
