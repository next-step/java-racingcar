package racing.domain;

import java.util.List;
import racing.model.CarInfo;

public class RoundResult {
    private final List<CarInfo> carInfoList;

    private RoundResult(List<CarInfo> carInfoList) {
        this.carInfoList = carInfoList;
    }

    public List<CarInfo> getCarInfoList() {
        return carInfoList;
    }

    public static RoundResult save(List<CarInfo> carInfoList) {
        return new RoundResult(carInfoList);
    }
}
