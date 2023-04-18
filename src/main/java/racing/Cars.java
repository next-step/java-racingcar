package racing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Cars {

    public static final Pattern COMMA_REGEX = Pattern.compile(",");
    public static final int MAX_LENGTH = 5;
    private final List<Car> cars;

    public Cars(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("Never allows empty input");
        }

        Arrays.stream(COMMA_REGEX.split(input))
            .forEach(validLength());

        this.cars = Arrays.stream(COMMA_REGEX.split(input))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream()
            .map(Car::getCarDTO)
            .collect(Collectors.toList());
    }

    private static Consumer<String> validLength() {
        return carName -> {
            if (MAX_LENGTH < carName.length()) {
                throw new RuntimeException("Car names cannot be more than 5 characters long.");
            }
        };
    }

}
