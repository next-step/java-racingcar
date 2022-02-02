package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MoveStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        verifyMinSize(cars);
        verifyDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    public static Cars of(List<String> nameList) {
        List<Car> cars = new ArrayList<>();
        for (String name : nameList) {
            cars.add(new RacingCar(name));
        }
        return new Cars(cars);
    }

    private void verifyMinSize(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalStateException();
        }
    }

    private void verifyDuplicate(List<Car> cars) {
        Set<String> carNames = cars.stream()
            .map(Car::getName)
            .collect(Collectors.toSet());

        if(carNames.size() != cars.size()){
            throw new IllegalStateException();
        }
    }

    public void moveAll(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(()-> new IllegalStateException("최대 위치를 구할 수 없습니다."));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        StringBuilder carsState = new StringBuilder();
        for (Car car : cars) {
            carsState.append(car);
            carsState.append("\n");
        }
        carsState.append("------------------------------\n");
        return carsState.toString();
    }
}
