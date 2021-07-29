package racing.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public void prepareCars(String[] carNames) {
        String[] carNameArr = carNames;
        for(String carName : carNameArr) {
           Car car = new Car(carName);
           carList.add(car);
        }
    }

    public void prepareCars(List<Car> cars) {
        carList = cars;
    }


    public List<Car> carList() {
        return this.carList;
    }

    public int getMaxDistance() {
        return carList()
                .stream()
                .max(Comparator.comparing(Car::totalDistance))
                .get()
                .totalDistance();
    }
}
