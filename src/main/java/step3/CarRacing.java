package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final List<Car> cars;

    public CarRacing(String carNameString) {
        this.cars = new ArrayList<>();

        String[] carNameArray = getCarNameListSplit(carNameString);

        for (int i = 0; i < carNameArray.length; i++) {
            cars.add(new Car(carNameArray[i]));
        }
    }

    private String[] getCarNameListSplit(String carNameList) {
        String[] carNameListSplit = carNameList.split(",");
        return carNameListSplit;
    }

    public List<Car> racing() {
        for (Car car : cars) {
            car.moveForward(CarUtils.getNumberForMovement());
        }
        return cars;
    }

}
