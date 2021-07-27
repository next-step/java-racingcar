package racing.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.carList = cars;
    }
    public void prepareCars(String carNames) {
        String[] carNameArr = carNames.split(",");
        for(String carName : carNameArr) {
           Car car = new Car(carName);
           carList.add(car);
        }
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
