package step2.domain;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final String CAR_NAME_DELIMITER = ",";

    private int numberOfCars;
    private Cars cars;

    public RacingGame(String nameOfCars) {
        String[] carNames = splitCarNameInput(nameOfCars);
        cars = new Cars();

        cars.createCars(carNames);

        this.numberOfCars = cars.extractNumberOfCars();
    }

    public String[] splitCarNameInput(String nameOfCars) {
        return nameOfCars.split(CAR_NAME_DELIMITER);
    }

    public List<String> retrieveWinners() {
        return this.cars.retrieveWinners();
    }

    public Cars race() {
        int length = this.numberOfCars;
        int random;

        List<Car> carCollection = cars.getCars();

        for (int i = 0; i < length; i++) {
            random = generateRandom();
            Car car = carCollection.get(i);
            car.move(random);
        }

        return this.cars;
    }

    public int generateRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber;
    }

    public Cars getCars() {
        return this.cars;
    }
}