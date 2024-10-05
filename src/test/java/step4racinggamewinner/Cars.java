package step4racinggamewinner;


import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String carNames) {
        cars = new ArrayList<>();
        List<String> carNamesList = List.of(carNames.split(","));
        registCars(carNamesList);
    }

    private void registCars(List<String> carNamesList) {
        for (String s : carNamesList) {
            Car car = new Car(s);
            cars.add(car);
        }
    }

    public int carCount() {
        return cars.size();
    }
}
