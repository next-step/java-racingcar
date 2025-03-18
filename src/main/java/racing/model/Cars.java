package racing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racing.service.NumberGenerator;

public class Cars {
    private static final int INIT_POSITION = 1;
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static Cars create(String[] carNames, NumberGenerator numberGenerator) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName, INIT_POSITION);
            carList.add(car);
        }
        return new Cars(carList, numberGenerator);
    }

    public Cars movedAll() {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars) {
            newCars.add(carMove(car));
        }
        return new Cars(newCars, numberGenerator);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinner() {
        return collectWinners(seekMaxPosition());
    }

    private Car carMove(Car car) {
        return car.moved(numberGenerator.generateNumber());
    }

    private int seekMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    private List<Car> collectWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addIfWinner(maxPosition, car, winners);
        }

        return winners;
    }

    private void addIfWinner(int maxPosition, Car car, List<Car> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }
}
