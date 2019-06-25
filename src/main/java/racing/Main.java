package racing;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = InputView.getCarsByNames();
        int racingCount = InputView.getRacingCount();
        for (; racingCount > 0; racingCount--) {
            cars.forEach(car -> {
                car.move(new Random().nextLong() * 10);
                OutputView.showCarsProcess(car);
            });
            System.out.println();
        }

    }
}
