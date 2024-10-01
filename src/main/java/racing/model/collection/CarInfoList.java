package racing.model.collection;

import java.util.Collections;
import java.util.List;
import racing.model.CarInfo;

public class CarInfoList {

    private final List<CarInfo> carInfoList;

    public CarInfoList(List<CarInfo> carInfoList) {
        this.carInfoList = carInfoList;
    }

    public List<CarInfo> getCarInfos() {
        return Collections.unmodifiableList(carInfoList);
    }
}
