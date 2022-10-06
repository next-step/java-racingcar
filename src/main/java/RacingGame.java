import domain.Car;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final Integer CONDITION = 4;
    Random random = new Random();

    public List<Car> makeCars(int carCnt) {
        List<Car> cars = new ArrayList<Car>(carCnt);
        for (int i = 0; i < carCnt; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void game(List<Car> cars) {
        cars.forEach(car -> {
            race(car, random.nextInt(10));
        });
    }

    public void race(Car car, int value) {
        if (value >= CONDITION) {
            car.move();
        }
    }
}
