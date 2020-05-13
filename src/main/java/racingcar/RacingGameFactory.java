package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarMovingCondition;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomCarMovingCondition;
import racingcar.domain.TimeBaseRandomGenerator;

public class RacingGameFactory {

    private RacingGameFactory() {
    }

    public static RacingGame newRacingGame(List<String> carNames){
        CarMovingCondition carMovingCondition = new RandomCarMovingCondition(new TimeBaseRandomGenerator(), 10, 4);
        List<Car> cars = carNames.stream().map(name -> new Car(name, carMovingCondition)).collect(Collectors.toList());
        return new RacingGame(new RacingCars(cars));
    }

}
