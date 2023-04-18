package racing.utils;

import racing.domain.Car;
import racing.domain.Game;
import racing.domain.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameCreateUtil {
    public static Game createGameWithStrategy(List<String> nameOfCars, MoveStrategy moveStrategy) {
        List<Car> cars = new ArrayList<>();
        for (String name : nameOfCars) {
            cars.add(new Car(name, moveStrategy));
        }
        return new Game(cars);
    }
}
