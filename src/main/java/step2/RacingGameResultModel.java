package step2;

import java.util.List;

public class RacingGameResultModel {
    private final List<Cars> cars;

    public RacingGameResultModel(List<Cars> cars) {
        this.cars = cars;
    }

    public List<Cars> getCars() {
        return cars;
    }

}
