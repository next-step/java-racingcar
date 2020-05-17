package game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private final int time;
    private final List<Car> carList;

    public RacingGame(int time, int numberOfCar, MovePolicy movePolicy) {
        this.time = time;
        this.carList = new ArrayList<>();
        IntStream.range(0, numberOfCar).forEach(i -> carList.add(new Car(i, 0, movePolicy)));
    }

    public void play() {
        for (int i = 0; i < time; i++) {
            carList.forEach(Car::move);
        }
    }
}
