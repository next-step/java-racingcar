package car_racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carsForGame;

    public Cars(int numberOfCars) {
        carsForGame = createCars(numberOfCars);
    }

    /** Test **/
    public Cars(List<Car> carsForGame) {
        this.carsForGame = carsForGame;
    }

    public void playOneRound() {
        for(Car car: carsForGame) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return carsForGame;
    }

    public int numberOfCars() {
        return carsForGame.size();
    }

    private List<Car> createCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for(int carId = 0; carId < numberOfCars; carId++) {
            cars.add(new Car(carId));
        }
        return cars;
    }

}
