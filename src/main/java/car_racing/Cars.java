package car_racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private static final String NAME_DELIMITER = ",";

    private final List<Car> carsForGame;

    public Cars(int numberOfCars) {
        this.carsForGame = createCars(numberOfCars);
    }

    public Cars(String names) {
        this.carsForGame = createCars(names);
    }

    /**
     * Test
     **/
    public Cars(List<Car> carsForGame) {
        this.carsForGame = carsForGame;
    }

    private List<Car> createCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int carCount = 0; carCount < numberOfCars; carCount++) {
            cars.add(new Car());
        }
        return cars;
    }

    private List<Car> createCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] names = carNames.split(NAME_DELIMITER);

        for (String name : names) {
            Name carName = new Name(name);
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public void playOneRound(MoveStrategy moveStrategy) {
        for (Car car : carsForGame) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCars() {
        return carsForGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars = (Cars) o;
        return Objects.equals(carsForGame, cars.carsForGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsForGame);
    }
}
