package racingGame;

import racingGame.racingRule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private List<Car> cars;
    private InputParameters inputParameters;

    public RacingGame(InputParameters inputParameters) {
        this.inputParameters = inputParameters;
        this.cars = createCars();
    }

    public Cars play(RacingRule racingRule) {
        IntStream.range(0, inputParameters.tryNum)
                .forEach(car -> moveCar(racingRule));
        return new Cars(cars);
    }

    private void moveCar(RacingRule racingRule) {
       cars.stream().forEach(car -> car.move(racingRule));
    }

    private List<Car> createCars() {
        List<Car> mocCars = new ArrayList<>();
        addNewCar(mocCars);
        return mocCars;
    }

    private void addNewCar(List<Car> mocCars) {
        for (int i =0; i < inputParameters.getCarNum(); i++){
           mocCars.add(new Car());
        }
    }

}
