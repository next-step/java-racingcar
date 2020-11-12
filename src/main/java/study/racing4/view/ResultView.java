package study.racing4.view;

import study.racing4.Car;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public void printCarPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : -");
            IntStream.range(0, car.getPosition())
                    .forEach(t -> System.out.print("-"));
            System.out.println();
        }
        System.out.println();
    }

}
