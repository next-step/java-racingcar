package carracing.application;

import carracing.domain.Car;
import carracing.domain.CarFactory;
import carracing.domain.Cars;
import carracing.domain.RaceResult;
import java.util.List;

public class CarRacing {

    public RaceResult race(String inputName, int raceCount) {
        String[] names = inputName.split(",");
        Cars cars = new Cars(makeCars(names));
        RaceResult raceResults = new RaceResult(raceCount);

        for (int i = 0; i < raceCount; i++) {
            cars.moveCars();
            raceResults.saveResult(cars);
        }
        raceResults.saveWinners(cars.findWinner());
        return raceResults;
    }

    private List<Car> makeCars(String[] names) {
        return CarFactory.makeCars(names);
    }

}
