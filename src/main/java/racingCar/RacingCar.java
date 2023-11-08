package racingCar;

import java.util.Random;

public class RacingCar {
    private int carCount;
    private int chance;
    private Car[] cars;

    public RacingCar(int carCount, int chance) {
        this.carCount = carCount;
        this.chance = chance;
        initCars(carCount);
    }

    private void initCars(int carCount) {
        this.cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            this.cars[i] = new Car();
        }
    }

    public void racing() {
        for (int i = 0; i < chance; i++) {
            for (int j = 0; j < carCount; j++) {
                this.cars[j].moveCar(getRandomValue());
                ResultView.printRacingResult(this.cars[j]);
            }
            System.out.println("*******************************************");
        }
    }

    private int getRandomValue() {
        return new Random().nextInt(10);
    }
}
