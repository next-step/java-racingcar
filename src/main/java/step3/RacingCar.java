package step3;

import java.util.Random;

public class RacingCar {

    private final int numberOfCar;
    private final int numberOfRace;

    private int[] cars;

    public RacingCar(final int numberOfCar, final int numberOfRace) {
        this.cars = new int[numberOfCar];

        this.numberOfCar = numberOfCar;
        this.numberOfRace = numberOfRace;
    }

    public int getNumberOfCar() {
        return this.numberOfCar;
    }

    public int getNumberOfRace() {
        return this.numberOfRace;
    }

    public int getCar(int index) {
        return this.cars[index];
    }

    public void generateRandomNumber() {
        Random random = new Random();

        for (int car : cars) {
            car = random.nextInt(10);
        }
    }

}
