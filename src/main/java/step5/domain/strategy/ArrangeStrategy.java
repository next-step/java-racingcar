package step5.domain.strategy;

import step5.domain.Car;

import java.util.List;

public interface ArrangeStrategy {
    List<Car> arrangeCarList(List<Car> carList);
}
