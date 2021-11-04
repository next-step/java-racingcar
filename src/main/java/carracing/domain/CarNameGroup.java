package carracing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차들의 이름을 저장하는 클래스
 */
public class CarNameGroup {
    public static final String DELIMITER = ",";

    private List<CarName> carNames;

    public CarNameGroup(String carNames) {
        validateCarNames(carNames);
        initiateCarNames(carNames);
    }

    private void validateCarNames(String carNames) {
        if (isCarNamesEmpty(carNames)) {
            throw new IllegalArgumentException("자동차들의 이름은 비어있을 수 없습니다.");
        }
    }

    private boolean isCarNamesEmpty(String carNames) {
        return carNames == null || carNames.isEmpty();
    }

    private void initiateCarNames(String carNames) {
        this.carNames = convertCarNames(carNames);
    }

    private List<CarName> convertCarNames(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    public List<CarName> getNames() {
        return carNames;
    }
}
