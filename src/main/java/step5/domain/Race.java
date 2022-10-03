package step5.domain;

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
        for (Car car : cars.getCars()) {
            car.move(new RandomMovingStrategy());
        }
        return cars;
    }

    public Cars getCars() {
        return this.cars;
    }

}
