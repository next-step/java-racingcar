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
        List<Car> newCars = new ArrayList<>();
        for (int carNumber = 0; carNumber < cars.size(); carNumber++) {
            Car movedCar = cars.get(carNumber)
                    .move(new MoveStrategy(
                            new RandomCondition().getRandomCondition()));
            newCars.add(movedCar);
        }
        return new Cars(newCars);
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

}
