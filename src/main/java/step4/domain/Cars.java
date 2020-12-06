package step4.domain;

import step4.domain.judge.Judge;
import step4.domain.strategy.MovingStrategy;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(MovingStrategy movingStrategy) {
        cars.stream()
                .forEach(car -> car.move(movingStrategy));
    }

    public String winnerCars(Judge judge) {
        return (String) judge.judge(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

}
