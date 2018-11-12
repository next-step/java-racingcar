package game;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(String names) {
        cars = CarList.makeCars(names);
    }

    public List<Car> playGame() {
        for(Car car : cars){
            car.move(getRandomValue());
        }
        return cars;
    }
    private int getRandomValue() {
        return new Random().nextInt(10);
    }
}
