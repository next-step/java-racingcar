package car_racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carsForGame;

    public Cars(int numberOfCars) {
        this.carsForGame = createCars(numberOfCars);
    }

    /**
     * Test
     **/
    public Cars(List<Car> carsForGame) {
        this.carsForGame = carsForGame;
    }

    public void playOneRound(MoveStrategy moveStrategy) {
        for (Car car : carsForGame) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCars() {
        return carsForGame;
    }

    private List<Car> createCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int carCount = 0; carCount < numberOfCars; carCount++) {
            cars.add(new Car());
        }
        return cars;
    }

}
