package racing.domain.dto;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;

public class ResultDto {
    private final List<Car> cars;
    private final int count;

    public static final int EMPTY_VALUE = 0;

    public ResultDto(List<Car> cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCount() {
        return count;
    }

    public String findWinners(){
        int max = maxMoveCount();
        return cars.stream().
            filter(car -> car.isWinner(max))
            .map(Car::getName)
            .collect(Collectors.joining(","));
    }

    public int maxMoveCount(){
        return cars
            .stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElse(EMPTY_VALUE);
    }
}
