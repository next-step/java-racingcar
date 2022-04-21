package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        validateCarNames(carNames);
        this.carNames = carNames;
    }

    private void validateCarNames(List<CarName> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("빈 컬렉션은 CarNames를 생성 할 수 없다.");
        }
    }

    public static CarNames from(List<String> names) {
        return new CarNames(names.stream()
                .map(CarName::new)
                .collect(Collectors.toList()));
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
