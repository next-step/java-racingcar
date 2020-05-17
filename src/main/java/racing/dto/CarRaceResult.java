package racing.dto;

import racing.utils.EmptyCheckUtil;

public class CarRaceResult {
    private static final int MIN_POSITION = 0;

    private String carName;
    private int position;

    public CarRaceResult(String carName, int position) {
        EmptyCheckUtil.emptyCheck(carName);
        this.validatePosition(position);
        this.carName = carName;
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION) {
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
