package carracing.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차들의 이름을 저장하는 클래스
 */
public class CarNames {
    private List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        validateCarNames(carNames);
        initiateCarNames(carNames);
    }

    private void validateCarNames(List<CarName> carNames) {
        if (isCarNamesEmpty(carNames)) {
            throw new IllegalArgumentException("자동차들의 이름은 비어있을 수 없습니다.");
        }
    }

    private boolean isCarNamesEmpty(List<CarName> carNames) {
        return carNames == null || carNames.isEmpty();
    }

    private void initiateCarNames(List<CarName> carNames) {
        this.carNames = new ArrayList<>(carNames.size());
        for (CarName carName : carNames) {
            addCarName(carName);
        }
    }

    private void addCarName(CarName carName) {
        carNames.add(carName);
    }

    public List<CarName> getNames() {
        return carNames;
    }
}
