package step3to5.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public List<String> decisionOfChampion() {
        int highScore = getCar(0).getScore();
        List<String> champions = new ArrayList<>();

        for (Car car : cars) {
            highScore = validateHighScore(car, highScore);
        }

        for (Car car : cars) {
            champions = validateChampion(car, highScore, champions);
        }
        return champions;
    }

    public int validateHighScore(Car car, int highScore) {
        if (car.getScore() > highScore) {
            highScore = car.getScore();
        }
        return highScore;
    }

    public List<String> validateChampion(Car car, int highScore, List<String> champions) {
        if (car.getScore() == highScore) {
            champions.add(car.getName());
        }
        return champions;
    }
}
