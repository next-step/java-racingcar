package racing.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        validation(cars);
        this.cars = cars;
    }

    public void validation(List<Car> cars) {
        if (isDuplicated(getCarNames(cars))) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    public List<String> getCarNames(List<Car> cars){
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public boolean isDuplicated(List<String> names) {
        return (new HashSet<>(names).size()) != names.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void advanceCars(GameCondition gameCondition) {
        cars.forEach(car -> car.advance(gameCondition));
    }

    public int getWinnerDistance(){
        return cars.stream()
                .mapToInt(Car::getNumberOfAdvance)
                .max()
                .orElse(0);
    }

    public List<String> getWinnerNames(){
        int winnerDistance = getWinnerDistance();
        return cars.stream()
                .filter(car -> car.getNumberOfAdvance() == winnerDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
