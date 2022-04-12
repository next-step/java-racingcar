package step3.car;

import java.util.ArrayList;
import java.util.List;
import step3.view.ResuiltView;

public class Cars {

    private final List<Car> cars;

    private Cars(int count) {
        List<Car> cars = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            cars.add(Car.of());
        }
        this.cars = cars;
    }

    public static Cars of(int count) {
        return new Cars(count);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public void play() {
        for (Car car : this.cars) {
            car.move();
            ResuiltView.show(car.getState());
        }
        System.out.println();
    }
}
