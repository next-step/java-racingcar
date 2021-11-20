package racingcar.domain;

import static racingcar.utils.StringLengthValidator.validUnderMaxLength;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<String> names = new ArrayList<>();

    private Participants(String input) {
        String[] joinCarNames = input.split(",");

        for (String carName : joinCarNames) {
            validUnderMaxLength(carName, 5);
            names.add(carName);
        }
    }

    public static Participants join(String input) {
        return new Participants(input);
    }

    public List<Car> ready() {
        return names.stream()
            .map(Car::create)
            .collect(Collectors.toList());
    }

}
