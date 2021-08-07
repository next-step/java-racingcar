package racingcar;

import java.util.LinkedList;
import java.util.List;

public class Round {

    List<Car> cars;

    public Round(List<Car> carsFromPreviousRound) {
        this.cars = new LinkedList<>();
        carsFromPreviousRound.stream().forEach(car -> this.cars.add(new Car(car)));
    }

    public List<Car> moveCars() {
        cars.stream().forEach(car-> car.move(new RandomNumGenerator().getRandomNumber()));
        return cars;
    }


}
