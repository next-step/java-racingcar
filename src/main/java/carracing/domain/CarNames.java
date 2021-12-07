package carracing.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차들의 이름을 저장하는 클래스
 */
public class CarNames {
    public static final String DELIMITER = ",";

    private final List<CarName> carNames;

    public CarNames(String carNames) {
        validateCarNames(carNames);
        this.carNames = carNames(carNames);
    }

    public List<CarName> getNames() {
        return Collections.unmodifiableList(carNames);
    }

    private void validateCarNames(String carNames) {
        if (isCarNamesEmpty(carNames)) {
            throw new IllegalArgumentException("자동차들의 이름은 비어있을 수 없습니다.");
        }
    }

    private boolean isCarNamesEmpty(String carNames) {
        return carNames == null || carNames.isEmpty();
    }

    private List<CarName> carNames(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(CarName::new)
                .collect(Collectors.toList());
    }
}
