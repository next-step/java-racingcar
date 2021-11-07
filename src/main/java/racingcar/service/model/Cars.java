package racingcar.service.model;

import racingcar.service.domain.Car;
import racingcar.service.value.CarName;
import racingcar.service.value.Position;
import racingcar.utils.Preconditions;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        Preconditions.checkNotNull(carList, "carList는 필수값입니다.");

        this.carList = cloneList(carList);
    }

    public static Cars from(List<Car> carList) {
        return new Cars(carList);
    }

    private static List<Car> cloneList(List<Car> originCars) {
        return originCars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
    }

    public String getFinalWinnerName() {
        Position maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getCarName)
                .map(CarName::getName)
                .collect(Collectors.joining(", "));
    }

    private Position getMaxPosition() {
        Position maxPosition = Position.init();
        for (Car car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
