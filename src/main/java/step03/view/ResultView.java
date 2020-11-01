package step03.view;

import step03.Car;
import java.util.List;

public class ResultView {

    public static void print(List<Car> cars) {
        cars.forEach((car) -> System.out.println(car.position()));
        System.out.println();
    }

}
