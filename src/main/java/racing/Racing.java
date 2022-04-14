package racing;

import racing.exception.AttemptsCountNegativeNumberException;
import racing.exception.CarsNullPointerException;

import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    private final List<Car> cars;
    private final RacingGameManagement carDrivingStatus;
    private final int attemptsCount;

    public Racing(List<Car> cars, int attemptsCount, RacingGameManagement carDrivingStatus) {
        this.cars = cars;
        this.attemptsCount = attemptsCount;
        this.carDrivingStatus = carDrivingStatus;
    }

    public void StartRacing() {
        if (cars == null) {
            throw new CarsNullPointerException();
        }

        if (attemptsCount <= 0) {
            throw new AttemptsCountNegativeNumberException();
        }

        IntStream.range(0, attemptsCount).forEach(i -> moveCars());
    }

    private void moveCars() {
        cars.forEach(car -> moveCar(car, RandomMoveNumber.generate()));
    }

    public void moveCar(Car car, int count) {
        carDrivingStatus.addStatus(car.getId(), Move(count));
    }

    private CarDriving Move(int move) {
        if (move >= 4) {
            return CarDriving.GO;
        }

        return CarDriving.STOP;
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

}
