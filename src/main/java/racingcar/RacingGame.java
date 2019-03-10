package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private Random random = new Random();
    private int time;
    private List<Car> carPositions;

    public void setCarNumber(int carNumber) {
        carPositions = new ArrayList<>(carNumber);
        for(int i = 0; i < carNumber; i++) {
            carPositions.add(new Car());
        }
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void move() {
        for(int i = 0; i < carPositions.size(); i++) {
            carPositions.get(i).moveCar(random.nextInt(10));
        }
    }

    public void gameStart() {
        for(int i = 0; i < time; i++) {
            move();
            ResultView.viewCars(carPositions);
        }
    }
}
