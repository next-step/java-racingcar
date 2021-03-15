package racing.factories;

import racing.models.Car;
import racing.models.Cars;
import racing.models.Round;

import java.util.List;

public class RoundFactory {
    public static Round createFrom(Cars cars) {
        return new Round(cars.deepCopyToList());
    }

    public static Round createFrom(List<Car> carList) {
        return new Round(carList);
    }
}
