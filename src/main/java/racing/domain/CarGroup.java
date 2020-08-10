package racing.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private List<Car> carList;

    public CarGroup(String[] arrCarName) {
        carList = Arrays.stream(arrCarName).map(carName -> new Car(carName)).collect(Collectors.toList());
    }

    public String getWinnerNames() {
        return carList.stream()
                .filter(car -> car.getLocation() == getTopLocation())
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }

    public int getTopLocation() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get()
                .getLocation();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
