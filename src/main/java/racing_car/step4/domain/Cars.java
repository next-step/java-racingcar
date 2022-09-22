package racing_car.step4.domain;

import racing_car.step4.dto.CarDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    
    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    
    public List<Car> moveTry() {
        return moveTry(new RandomMoveStrategy());
    }
    
    public List<Car> moveTry(MoveStrategy moveStrategy) {
        return cars.stream()
                .map(car -> car.moveTry(moveStrategy))
                .collect(Collectors.toList());
    }
    
    public List<CarDTO> information() {
        return cars.stream()
                .map(Car::information)
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
