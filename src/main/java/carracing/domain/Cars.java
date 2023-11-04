package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public int getCarListSize() {
        return carList.size();
    }

    public void move(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            carList.forEach(Car::move);
        }
    }

    public void getCarsPotion() {
        carList.forEach(car -> System.out.println(car.getPosition()));
    }
}
