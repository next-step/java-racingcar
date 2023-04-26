package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void checkForwardConditionAndGo() {
        for (Car car : cars) {
            car.increaseDistance();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }


    public RoundScores getRoundResult() {
        List<RoundScore> roundScores = new ArrayList<>();
        for (Car car : cars) {
            roundScores.add(new RoundScore(car.getName(), car.getDistance()));
        }

        return new RoundScores(roundScores);
    }

    public int getCarSize() {
        return cars.size();
    }

    public static Cars generateCars(String carNames) {
        String[] carName = carNames.split(Constant.DELIMITER);
        List<Car> tempCars = new ArrayList<>();
        for (String name : carName) {
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
            Car car = new Car(name, randomNumberGenerator);
            tempCars.add(car);
        }

        return new Cars(tempCars);
    }

}
