package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class CarsNames {

    private List<CarName> carsNames;

    public CarsNames(String... carsNames) {
        validEmpty(carsNames);
        validBlank(carsNames);
        this.carsNames = createCarName(carsNames);
    }

    private List<CarName> createCarName(String... carsNames) {
        List<CarName> carsNameList = new ArrayList<>();
        for (String carName : carsNames) {
            carsNameList.add(new CarName(carName));
        }
        return carsNameList;
    }

    private void validEmpty(String... carsNames) {
        if (carsNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
    }

    private void validBlank(String... carsNames) {
        for (String carName : carsNames) {
            validBlank(carName);
        }
    }

    private void validBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
    }

    public int size() {
        return carsNames.size();
    }

    public CarName getName(int index) {
        return carsNames.get(index);
    }
}
