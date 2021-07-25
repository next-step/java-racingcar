package step4.model;

import java.util.List;

public interface CarsStrategy {
    void move(Cars cars);
    List<Car> arrange(List<Car> carsList);
}
