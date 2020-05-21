package racingcar.domain;

import java.util.stream.Collectors;

public class GameResult {
    private static final String OUTPUT_CHARACTERS = "-";

    private final Cars cars;

    public GameResult(Cars cars) {
        this.cars = cars;
    }

    public String getResult() {
        return cars.getCars()
                .stream()
                .map(car -> {
                    int carPosition = car.getPosition();
                    String carName = car.getName();

                    return carName.concat(" : ").concat(replacePositionToOutputCharacters(carPosition));
                })
                .collect(Collectors.joining("\n"));
    }

    private String replacePositionToOutputCharacters(int carPosition) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < carPosition; i++) {
            sb.append(OUTPUT_CHARACTERS);
        }

        return sb.toString();
    }
}
