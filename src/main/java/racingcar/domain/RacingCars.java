package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.behavior.MovingStrategy;

public class RacingCars {

    private  List<Car> cars;
    private  MovingStrategy movingStrategy;

    public RacingCars(List<Car> cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public static RacingCars of(String [] numOfCar, MovingStrategy movingStrategy) {
        int size = numOfCar.length;
        List<Car> initCars = createCars(size);
        return new RacingCars(initCars, movingStrategy);
    }

    private void getCarName(String[] nameOfCars,int numOfCar){
        for (String carName: nameOfCars) {
            createCars()
        }
    }

    public static List<Car> createCars(int numOfCar,String carName) {
        return Stream.generate(Car::new(carName))
                .limit(numOfCar)
                .collect(Collectors.toList());
    }

    public void run() {
        cars.forEach(this::moveCar);
    }

    private void moveCar(final Car car) {
        car.move(movingStrategy);
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
