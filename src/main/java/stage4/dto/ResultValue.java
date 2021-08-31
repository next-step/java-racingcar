package stage4.dto;

import stage4.domain.Car;

public class ResultValue {
    private final String carName;
    private final int currentStatus;

    public ResultValue (String carName, int currentStatus) {
        this.carName = carName;
        this.currentStatus = currentStatus;
    }

    public int getCurrentStatus() {
        return this.currentStatus;
    }

    public String getCarName() {
        return this.carName;
    }

    public static ResultValue formatCarToResultValue(Car car) {
        return new ResultValue(car.getName().getName(), car.getPosition().getPosition());
    }
}
