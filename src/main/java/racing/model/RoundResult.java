package racing.model;

import java.util.Collections;
import java.util.List;

public class RoundResult {
    private final List<CarInfo> carInfos;

    private RoundResult(List<CarInfo> carInfos) {
        this.carInfos = carInfos;
    }

    public List<CarInfo> getCarInfos() {
        return Collections.unmodifiableList(carInfos);
    }

    public static RoundResult save(List<CarInfo> carInfos) {
        return new RoundResult(carInfos);
    }
}
