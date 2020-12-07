package racing;

import java.util.ArrayList;
import java.util.List;

public class ParticipateCars {
    private static final List<Car> cars = new ArrayList<>();

    public ParticipateCars() {
    }

    public ParticipateCars(String[] cars) {
        createCar(cars);
    }

    protected ArrayList<Car> createCar(String[] carNames) {
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
        return new ArrayList<>(this.cars);
    }

    public void moveCar() {
        for (Car car : this.cars) {
            int randomNumber = RandomGenerator.getRandomNumber();
            car.run(randomNumber);
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(this.cars);
    }

}
