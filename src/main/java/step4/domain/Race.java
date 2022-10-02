package step4.domain;

import step4.util.RandomNumberGenerator;

import java.util.HashSet;
import java.util.Set;

public class Race {

    private Cars cars;

    public void setUpRace(String[] carNames) {
        Set<Car> carSet = new HashSet<>(carNames.length);

        for (String name : carNames) {
            Car car = new Car(name);
            carSet.add(car);
        }
        this.cars = new Cars(carSet);
    }

    public Cars runOneRound() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        for (Car car : cars.getCarSet()) {
            car.move(randomNumberGenerator.isGreaterThanThree());
        }
        return cars;
    }

    public Cars getCars() {
        return this.cars;
    }

}
