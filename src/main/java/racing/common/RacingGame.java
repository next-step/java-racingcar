package racing.common;

import racing.Car;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGame {
    private Cars cars;
    private int time;
    
    public RacingGame(String carNames, int time) {
        String[] cars = carNames.split(",");
        this.cars.setCars(Arrays.stream(cars)
            .map(carName -> new Car(carName))
            .collect(Collectors.toList())
        );
    }
}
