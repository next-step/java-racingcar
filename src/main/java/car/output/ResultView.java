package car.output;

import car.domain.Car;

import java.util.List;

public interface ResultView<T extends Car> {
    void print(List<T> cars, int tryNum);
}
