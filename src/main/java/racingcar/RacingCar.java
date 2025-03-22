package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.generator.RandomGenerator;
import racingcar.strategy.RandomStrategy;
import racingcar.ui.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    
    public static void gameStart() {
        Cars cars = new Cars(getCars(InputView.inputValidatedNumberOfCar()));
        Race race = new Race(cars, InputView.inputValidatedNumberOfAttempts());
        race.start(createRandomStrategy());
    }

    public static void gameStartWithName() {
        Race race = new Race(
                new Cars(InputView.inputdNameOfCar())
                , InputView.inputValidatedNumberOfAttempts());
        race.startWithName(createRandomStrategy());
    }


    public static List<Car> getCars(int car) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < car; i++) {
            cars.add(new Car());
        }
        return cars;
    }


    private static RandomStrategy createRandomStrategy() {
        return new RandomStrategy(new RandomGenerator());
    }

}
