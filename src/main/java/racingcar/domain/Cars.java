package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final String COMMA_SEPARATOR = ",";

    private final List<Car> values;

    public Cars(String carNames) {
        this.values = createCarList(carNames);
    }

    public Cars(List<Car> values) {
        this.values = values;
    }

    private List<Car> createCarList(String carNames) {
        List<String> carNameValues = Arrays.asList(carNames.split(COMMA_SEPARATOR));
        return carNameValues.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<CarDto> move(MovingStrategy movingStrategy) {
        List<CarDto> carValues = new ArrayList<>();
        for (Car value : values) {
            value.moves(movingStrategy);
            carValues.add(new CarDto(value.getName(), value.getPosition()));
        }
        return carValues;
    }

    private static List<String> toStringList(String value) {
        String[] splitValues = value.replace(BLANK_STRING, EMPTY_STRING).split(COMMA_SEPARATOR);
        for (String splitValue : splitValues) {
            checkInvalidInputValue(splitValue);
        }
        return Arrays.asList(splitValues);
    }

    private static void checkInvalidInputValue(String value) {
        if (isBlankValue(value) || isMoreThanValueLength(value)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    private static boolean isBlankValue(String value) {
        return value.isBlank();
    }

    private static boolean isMoreThanValueLength(String value) {
        return value.length() > CAR_NAME_MAX_LENGTH;
    }

    public List<Car> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(values, cars.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
