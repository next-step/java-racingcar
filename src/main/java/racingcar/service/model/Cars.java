package racingcar.service.model;

import racingcar.service.domain.Car;
import racingcar.service.value.Position;
import racingcar.utils.Preconditions;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
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
                .filter(car -> car.getCurrentPosition().equals(maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private Position getMaxPosition() {
        return carList.stream()
                .map(Car::getCurrentPosition)
                .max(Comparator.comparingInt(Position::getPosition))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
