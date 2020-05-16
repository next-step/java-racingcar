package racing.dto;

import racing.utils.EmptyCheckUtil;

public class CarRaceResult {
    private String carName;
    private int position;

    public CarRaceResult(String carName, int position) {
        this.carName = carName;
        this.position = position;
        EmptyCheckUtil.emptyCheck(carName);
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }
}
