package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars moveAllCar() {
        for (int carNumber = 0; carNumber < cars.size(); carNumber++) {
            cars.get(carNumber)
                    .move(new MoveStrategy(
                            new RandomCondition().getRandomCondition()))
            ;
        }
        return new Cars(cars);
    }

    public String getResults() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            writeAllCarsPosition(stringBuilder, car);
        }
        stringBuilder.append(RacingGameConstant.CARRIAGE_RETURN);
        return stringBuilder.toString();
    }

    private void writeAllCarsPosition(StringBuilder stringBuilder, Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(RacingGameConstant.CAR_MARKER);
        }
        stringBuilder.append(RacingGameConstant.CARRIAGE_RETURN);
    }

    public int size() {
        return cars.size();
    }
}
