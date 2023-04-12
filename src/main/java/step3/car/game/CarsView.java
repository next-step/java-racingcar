package step3.car.game;

import java.util.stream.IntStream;

public class CarsView {

    public void print(Cars cars) {
        cars.cars()
                .stream()
                .forEach(car -> print(car));
        System.out.println("");
    }

    private void print(Car car) {
        IntStream.range(0, car.location())
                .forEach(value -> System.out.print("-"));
        System.out.println("");
    }
}
