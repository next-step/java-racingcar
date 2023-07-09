package racingcar.domain;

import racingcar.exception.CarNameInputException;

import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    public static final String EMPTY_CAR_NAME_MESSAGE = ",(쉼표)만 입력이 들어왔습니다. 자동차 이름도 함께 입력해주세요.";
    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        validate(carNames);
        this.carNames = carNames;
    }

    private void validate(List<CarName> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new CarNameInputException(EMPTY_CAR_NAME_MESSAGE);
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
