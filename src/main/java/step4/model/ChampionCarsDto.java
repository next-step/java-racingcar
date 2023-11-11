package step4.model;

import java.util.List;
import java.util.stream.Collectors;

public class ChampionCarsDto {
    private List<Car> cars;

    public ChampionCarsDto(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        List<String> carNames = cars.stream().map(Car::getName).collect(Collectors.toList());
        return String.join(", ", carNames) + "가 최종 우승했습니다.";
    }

    public List<Car> getCars() {
        return cars;
    }
}
