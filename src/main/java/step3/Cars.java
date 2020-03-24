package step3;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String[] carNames) {
        for(int i = 0; i < carNames.length; i++) {
            this.cars.add(createCar(carNames[i]));
        }
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
