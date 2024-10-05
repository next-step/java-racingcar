package step4racinggamewinner;


import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static final int MAX_CARNAME_LENGTH = 5;
    private List<Car> cars;

    public Cars() {
    }

    public Cars(String carNames) {
        cars = new ArrayList<>();
        List<String> carNamesList = List.of(carNames.split(","));

        checkNameLength(carNamesList);
        registCars(carNamesList);
    }

    private void registCars(List<String> carNamesList) {
        carNamesList.stream().map(Car::new).forEachOrdered(car -> cars.add(car));
    }

    public void checkNameLength(List<String> carNamesList) {
        for (String carName : carNamesList) {
            if (carName.length() > MAX_CARNAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int carCount() {
        return cars.size();
    }


}
