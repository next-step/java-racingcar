package racing.common;

import racing.Car;
import racing.RandomNumberGenerator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingManager {
    private Cars cars;
    private RandomNumberGenerator randomGenerator;
    
    public RacingManager(String carNames) {
        this.cars = new Cars(Arrays.stream(carNames.split(","))
          .map(carName -> new Car(carName))
          .collect(Collectors.toList())
        );
        randomGenerator = new RandomNumberGenerator(RacingSettings.MAX_RANDOM_MOVABLE_NUMBER.getValue());
    }
    
    public void moveCars() {
        // cars 를 돌면서 움직여도 될지 말지를 정해 차를 움지깅ㄴ다.
    }
}
