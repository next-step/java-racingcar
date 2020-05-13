package racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameFactory {

    private RacingGameFactory() {
    }

    public static RacingGame newRacingGame(int numberOfCar){
        CarMovingCondition carMovingCondition = new RandomCarMovingCondition(new TimeBaseRandomGenerator(), 10, 4);

        RacingCars racingCars =  new RacingCars(
            IntStream.range(0, numberOfCar)
                .mapToObj(value -> new Car(carMovingCondition))
                .collect(Collectors.toList())
        );

        return new RacingGame(racingCars);
    }

}
