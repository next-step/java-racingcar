package step3;

import java.util.List;

public class CarList {
    private final List<Car> cars;
    private final RandomNumberCreator randomNumberCreate;

    public static CarList from(List<Car> cars, RandomNumberCreator randomNumberCreate) {
        return new CarList(cars, randomNumberCreate);
    }

    public CarList(List<Car> cars, RandomNumberCreator randomNumberCreate) {
        this.cars = cars;
        this.randomNumberCreate = randomNumberCreate;
    }

    public void moveWithRandomNumber() {
        cars.stream().forEach(car -> car.move(randomNumberCreate.getRandomNumber()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
