package racingcar.domain;

import racingcar.exception.CarNameInputException;

import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    public static final String INVALID_INPUT_MESSAGE = "잘못된 입력이 들어왔습니다.";
    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        validate(carNames);
        this.carNames = carNames;
    }

    private void validate(List<CarName> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new CarNameInputException(INVALID_INPUT_MESSAGE);
        }
    }

    public Cars toCars() {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public List<String> getNames() {
        return this.carNames.stream()
                .map(CarName::getValue)
                .collect(Collectors.toList());
    }
}
