package racing_car.step3.domain;

import racing_car.step3.dto.CarDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    
    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    
    public void move() {
        move(new RandomMoveStrategy());
    }
    
    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
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
