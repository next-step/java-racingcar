package racinggame;

import racinggame.domain.Car;
import racinggame.domain.RacingResult;
import racinggame.service.CarAdvanceService;
import racinggame.service.RandomValueGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Configuration configuration;

    private CarAdvanceService carAdvanceService = new CarAdvanceService(new RandomValueGeneratorImpl());

    public RacingGame(Configuration configuration) {
        this.configuration = configuration;
    }

    public List<Car> createCars() {
        List<Car> cars = new ArrayList<>();

        for( String name : configuration.getCarNames() ) {
            cars.add( new Car(name) );
        }

        return cars;
    }

    public void proceed(RacingResult result) {
        carAdvanceService.moveForward(result.getCars());
    }
}