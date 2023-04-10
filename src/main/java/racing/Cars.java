package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final static MoveStrategy randomMove = new RandomMove();

    private final List<Car> cars;

    public Cars(Integer numberOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(randomMove));
    }

    public List<Integer> getMoves() {
        return cars.stream()
            .map(Car::getMove)
            .collect(Collectors.toList());
    }
    
}
