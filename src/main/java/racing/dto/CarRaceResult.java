package racing.dto;

import racing.utils.EmptyCheckUtil;

public class CarRaceResult {
    private String carName;
    private int position;

    public CarRaceResult(String carName, int position) {
        EmptyCheckUtil.emptyCheck(carName);
        this.validatePosition(position);
        this.carName = carName;
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }
}
