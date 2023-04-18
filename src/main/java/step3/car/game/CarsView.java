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
        System.out.print(car.name() + " : ");
        IntStream.range(0, car.location())
                .forEach(value -> System.out.print("-"));
        System.out.println("");
    }

    public void winner(Cars cars) {
        System.out.println(cars.winners() + " 가 최종우승했씁니다.");
    }
}
