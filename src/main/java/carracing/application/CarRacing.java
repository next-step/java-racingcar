package carracing.application;

import carracing.domain.Car;
import carracing.domain.CarFactory;
import java.util.List;

public class CarRacing {

    public List<Car> makeCars(int count) {
        return CarFactory.makeCars(count);
    }
}
