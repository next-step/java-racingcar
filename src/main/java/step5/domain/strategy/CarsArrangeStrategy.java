package step5.domain.strategy;

import step5.domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarsArrangeStrategy implements ArrangeStrategy {
    @Override
    public List<Car> arrangeCarList(List<Car> carList) {
        return carList.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .collect(Collectors.toList());
    }
}
