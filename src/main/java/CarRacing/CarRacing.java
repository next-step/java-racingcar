package CarRacing;

import java.util.List;

public class CarRacing {
    private Cars cars;

    public CarRacing(Cars cars) {
        this.cars = cars;
    }


    public void moveCars() {
        cars.getCars().forEach(car -> car.move());
    }

    public Cars getCars() {
        return cars;
    }
}
