package step5.racing.domain;

import java.util.Collections;
import java.util.List;

public class CarNames {

    private static final String DUPLICATE_CAR_NAMES_MESSAGE = "중복된 자동차 이름이 있습니다.";

    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        validate(carNames);
        this.carNames = carNames;
    }

    private void validate(List<CarName> carNames) {
        long distinctNames = countDistinctNames(carNames);

        if (distinctNames != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAMES_MESSAGE);
        }
    }

    private long countDistinctNames(List<CarName> carNames) {
        return carNames.stream()
                .map(CarName::value)
                .distinct()
                .count();
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }
}
