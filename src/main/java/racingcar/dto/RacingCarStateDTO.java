package racingcar.dto;

import racingcar.logic.RacingCar;

public final class RacingCarStateDTO {
    private final int carNo;
    private final int position;

    private RacingCarStateDTO(int carNo, int position) {
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
