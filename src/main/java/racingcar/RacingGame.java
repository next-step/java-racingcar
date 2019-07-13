package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Car> cars;
    private int numberOfGames;

    public RacingGame(String namesOfCars, int numberOfGames) {
        this.cars = initCars(namesOfCars);
        this.numberOfGames = numberOfGames;
    }

    public List<Car> initCars(String namesOfCars) {
        String[] names = namesOfCars.trim()
                .replace(" ", "")
                .split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move(generateRandomNumber());
        }
        numberOfGames--;
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isEnd() {
        return this.numberOfGames == 0;
    }

    public List<Car> getCars() {
        return cars;
    }
}
