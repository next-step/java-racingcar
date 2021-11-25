package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getSize() {
        return this.cars.size();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public Car getCar(int index) {
        return this.cars.get(index);
    }

    public String getWinners() {
        StringBuffer result = new StringBuffer();
        CarPosition maxMovement = getMaxPosition();
        for (Car car : this.cars) {
            if (car.isWinner(maxMovement)) {
                result.append(car.getCarName().getName()).append(", ");
            }
        }
        return result.substring(0, result.length() - 2);
    }

    private CarPosition getMaxPosition() {
        CarPosition maxPosition = new CarPosition(0);
        for (Car car : this.cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }
}
