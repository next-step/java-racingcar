package step5.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {

    private List<CarName> carNameGroup;

    public CarNames(List<String> carNames) {
        this.carNameGroup = new ArrayList<>();

        carNames.forEach(name -> {
            this.carNameGroup.add(new CarName(name));
        });
    }

    public List<CarName> getCarNameGroup() {
        return Collections.unmodifiableList(carNameGroup);
    }
}
