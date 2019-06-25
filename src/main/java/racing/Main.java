package racing;

import racing.view.InputView;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = InputView.getCarsByNames();
        cars.forEach(car -> car.move(new Random().nextLong() * 10));
        cars.forEach(e -> System.out.println(e.getPosition()));

    }
}
