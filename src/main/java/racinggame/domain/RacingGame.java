package racinggame.domain;

import racinggame.service.CarAdvanceService;
import racinggame.service.RandomValueGeneratorImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private int numberOfTries;

    private CarAdvanceService carAdvanceService = new CarAdvanceService(new RandomValueGeneratorImpl());

    public RacingGame(List<String> carNames, int numberOfTries) {
        this.cars = createCars(carNames);
        this.numberOfTries = numberOfTries;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for( String name : carNames ) {
            cars.add( new Car(name) );
        }

        return cars;
    }

    public void proceed(RacingResult result) {
        carAdvanceService.moveForward(result.getCars());
    }
}