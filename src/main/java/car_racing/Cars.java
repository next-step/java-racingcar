package car_racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(int numberOfCars) {
        this.cars = new ArrayList<>();

        for (int index = 0; index < numberOfCars; index++) {
            this.cars.add(new Car(index));
        }
    }

    public void goOrStop() {
        cars.forEach(car -> car.tryMove(GameRule.pickRandom()));
    }

    public List<Integer> straightCounts() {
        return cars.stream().map(Car::getStraightCount).collect(Collectors.toList());
    }

}
