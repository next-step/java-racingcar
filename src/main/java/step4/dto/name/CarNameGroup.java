package step4.dto.name;

import java.util.List;

public class CarNameGroup {
    private final List<String> carNameGroup;

    public CarNameGroup(List<String> carNameGroup) {
        this.carNameGroup = carNameGroup;
    }

    public List<String> getCarNameGroup() {
        return carNameGroup;
    }
}
