package racingcar.dto;

import racingcar.logic.RacingCar;

public final class RacingCarStateDTO {
    private final String carName;
    private final int carNo;
    private final int position;

    private RacingCarStateDTO(String carName, int carNo, int position) {
        this.carName = carName;
        this.carNo = carNo;
        this.position = position;
    }

    public static RacingCarStateDTO valueOf(RacingCar racingCar) {
        return new RacingCarStateDTO(racingCar.getCarNo(), racingCar.getPosition());
    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getPosition() {
        return this.position;
    }
}
