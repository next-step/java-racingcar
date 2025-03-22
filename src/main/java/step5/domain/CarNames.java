package step5.domain;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    private final List<CarName> carNames;

    public CarNames(String[] carNameArray) {
        ArrayList<CarName> carNames = new ArrayList<>();
        for (String carName : carNameArray) {
            carNames.add(new CarName(carName));
        }
        this.carNames = carNames;
    }

    public CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public List<CarName> getCarNames() {
        return this.carNames;
    }
}
