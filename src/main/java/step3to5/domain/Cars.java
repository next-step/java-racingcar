package step3to5.domain;

import step3to5.utils.GameRule;

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

    public void move(GameRule rule) {
        for (Car car : cars) {
            if (rule.isMovable()) {
                car.setScore();
            }
        }
    }

    public List<String> winners() {
        int highScore = 0;
        List<String> champions = new ArrayList<>();

        for (Car car : cars) {
            highScore = highScore(car, highScore);
        }

        for (Car car : cars) {
            champions = getCarsWithHighScore(car, highScore, champions);
        }
        return champions;
    }

    public int highScore(Car car, int highScore) {
        if (car.getScore() > highScore) {
            highScore = car.getScore();
        }
        return highScore;
    }

    public List<String> getCarsWithHighScore(Car car, int highScore, List<String> champions) {
        if (car.getScore() == highScore) {
            champions.add(car.getName());
        }
        return champions;
    }
}
