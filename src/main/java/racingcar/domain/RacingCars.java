package racingcar.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.behavior.MovingStrategy;
import racingcar.util.ErrorMessage;

public class RacingCars {
    private static final int MIN_NUM_OF_CARS = 0;

    private List<Car> cars;
    private MovingStrategy movingStrategy;

    public RacingCars(List<Car> cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public static RacingCars of(int numOfCar, MovingStrategy movingStrategy) {
        List<Car> initCars = createCars(numOfCar);
//        for(int i=0; i<numOfCar; i++){
//            initCars.add(new Car());
//        }
        return new RacingCars(initCars, movingStrategy);
    }

//    private RacingCars(final int numOfCar, final MovingStrategy movingStrategy) {
//        validateInput(numOfCar, movingStrategy);
//        this.movingStrategy = movingStrategy;
//        createCars(numOfCar);
//    }

//    private void validateInput(final int numOfCar, final MovingStrategy movingStrategy) {
//        if (numOfCar <= MIN_NUM_OF_CARS || movingStrategy == null) {
//            throw new IllegalArgumentException(ErrorMessage.INVALID_PARAMETER);
//        }
//    }

    public static List<Car> createCars(int numOfCar) {
        return Stream.generate(Car::new)
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
