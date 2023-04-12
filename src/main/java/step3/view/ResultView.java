package step3.view;

import step3.entity.Car;
import step3.entity.Cars;

import java.util.stream.IntStream;

public class ResultView {

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
