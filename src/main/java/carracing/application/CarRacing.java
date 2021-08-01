package carracing.application;

import static carracing.utils.RandomValueGenerator.generateRandom;

import carracing.domain.Car;
import carracing.domain.CarFactory;
import carracing.view.ResultView;
import java.util.List;

public class CarRacing {

    public ResultView race(int carCount, int raceCount) {
        List<Car> cars = makeCars(carCount);
        ResultView resultView = new ResultView();

        for (int i=0; i<raceCount; i++) {
            cars.stream().forEach(car -> car.move(generateRandom()));
            resultView.saveResult(cars);
        }
        return resultView;
    }

    public List<Car> makeCars(int count) {
        return CarFactory.makeCars(count);
    }
}
