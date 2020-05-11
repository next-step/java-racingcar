package racingcar;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(int numberOfCar) {
        this.cars = IntStream.range(0, numberOfCar)
            .mapToObj(value -> new Car())
            .collect(Collectors.toList());
    }

    public int getCarSize(){
        return cars.size();
    }

    void run() {

    }


    public void tryMove(int moveCount) {

    }
}
