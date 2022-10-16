package step4;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void printLocations(MaxLocation maxLocation) {
        for (Car car : cars) {
            System.out.print(car.getResult(maxLocation));
        }
        System.out.println();
    }

    public List<String> findWinnerName(MaxLocation maxLocation) {
        List<String> carNameList = new ArrayList<>();
        for (Car car : cars) {
            car.findName(carNameList, maxLocation);
        }
        return carNameList;
    }
}
