package racingGame.dto;

import racingGame.domain.Car;
import racingGame.domain.GameResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultDto {

    private List<Car> cars;

    public ResultDto(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getRacingResults() {
        return cars.stream()
            .map(car -> car.toString().replace("-", "&nbsp;"))
            .collect(Collectors.toList());
    }

    public String getWinnerNames() {
        return String.join(", ", GameResult.getWinners(cars).stream()
            .map(Car::getName).collect(Collectors.toList()));
    }

}
