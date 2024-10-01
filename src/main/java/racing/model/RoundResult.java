package racing.model;

import racing.model.collection.CarInfoList;

public class RoundResult {
    private final CarInfoList carInfoList;

    private RoundResult(CarInfoList carInfoList) {
        this.carInfoList = carInfoList;
    }

    public CarInfoList getCarInfoList() {
        return carInfoList;
    }

    public static RoundResult save(CarInfoList carInfoList) {
        return new RoundResult(carInfoList);
    }
}
