package step3;

import java.util.Random;

public class RacingCar {

    private final int numberOfCar;
    private final int numberOfRace;
    private final Random random = new Random();

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

    public int getCars(int index) {
        return this.cars[index];
    }

    public int generateRandomNumber() {
        return random.nextInt(10);
    }

    public void moveCar() {
        for (int i=0;i<numberOfCar;i++) {
            if (generateRandomNumber() >= 4)
                cars[i]++;
        }
    }

}
