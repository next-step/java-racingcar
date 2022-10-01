package racingGame.domain;

import racingGame.domain.racingRule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private List<Car> cars;
    private InputValue inputValue;

    public RacingGame(InputValue inputValue) {
        this.inputValue = inputValue;
        this.cars = createCars();
    }

    public Cars play(RacingRule racingRule) {
        IntStream.range(0, inputValue.getTryNum())
                .forEach(car -> moveCar(racingRule));
        return new Cars(cars);
    }

    private void moveCar(RacingRule racingRule) {
       cars.stream().forEach(car -> car.move(racingRule));
    }

    private List<Car> createCars() {
        List<Car> mocCars = new ArrayList<>();
        addNewCars(mocCars);
        return mocCars;
    }

    private void addNewCars(List<Car> mocCars) {
        for (int i = 0; i < inputValue.getCarsSize(); i++){
           mocCars.add(new Car(inputValue.getCarName().get(i)));
        }
    }

}
