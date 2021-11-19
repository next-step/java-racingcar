package step4.dto.name;

import step4.dto.count.Count;

import java.util.List;

public class CarNameGroup {
    private final List<String> carNameGroup;

    public CarNameGroup(List<String> carNameGroup) {
        this.carNameGroup = carNameGroup;
    }

    public List<String> getCarNameGroup() {
        return carNameGroup;
    }

    public Count carNameLength() {
        return new Count(carNameGroup.size());
    }
}
