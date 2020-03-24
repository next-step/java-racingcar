package step3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();

        for(int i = 0; i < carNames.length; i++) {
            cars.add(createCar(carNames[i]));
        }

        this.cars = cars;
    }

    private Car createCar(String carName) {
        Car car = new Car(carName);
        return car;
    }

    public void clear() {
        this.cars.clear();
    }

    public int getCarsLength() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

}
