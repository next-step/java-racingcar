package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private static final String OUTPUT_CHARACTERS = "-";

    private final List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getResult() {
        return cars.stream().map(car -> {
            int carPosition = car.getPosition();
            return replacePositionToOutputCharacters(carPosition);
        }).collect(Collectors.toList());
    }

    private String replacePositionToOutputCharacters(int carPosition) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < carPosition; i++) {
            sb.append(OUTPUT_CHARACTERS);
        }

        return sb.toString();
    }
}
