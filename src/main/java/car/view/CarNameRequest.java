package car.view;

import car.domain.Car;
import car.domain.CarList;

import java.util.*;

public class CarNameRequest {

    private final CarList carList;

    public CarNameRequest(CarList carList) {
        this.carList = carList;
    }

    public static CarNameRequest carListRequest() {
        List<Car> cars = new ArrayList<>();
        String carNames = new InputView().carNameScanner();

        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName));
        }

        return new CarNameRequest(new CarList(cars));
    }

    public CarList getCarNameList() {
        return carList;
    }


}
