package step1;

import java.util.Random;

import static racingCar.step1.RacingCarConfiguration.LIMIT_RANDOM_VALUE;
import static racingCar.step1.RacingCarConfiguration.MAX_RANDOM_VALUE;

public class Car {
    private String name;
    private StringBuilder position = new StringBuilder();
    private Random random = new Random();

    public Car (String name) {
        this.name = name;
    }

    public void step() {
        if(random.nextInt(MAX_RANDOM_VALUE.getValue()) >= LIMIT_RANDOM_VALUE.getValue())
            position.append("-");
    }

    public void printPosition() {
        System.out.println(this.name+" : "+position);
    }
    public int myPosition() {
        return position.length();
    }
    public String amIWinner(int maxPosition) {
        if(this.position.length() < maxPosition)
            return null;
        return this.name;
    }
}