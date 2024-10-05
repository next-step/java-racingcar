package racingcar.dto;

import racingcar.RacingCar;

public final class RacingCarStateDTO {
    private final int carNo;
    private final int position;

    private RacingCarStateDTO(int carNo, int position) {
        this.carNo = carNo;
        this.position = position;
    }

    public static RacingCarStateDTO fromRacingCar(RacingCar racingCar) {
        return new RacingCarStateDTO(racingCar.getCarNo(), racingCar.getPosition());
    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getPosition() {
        return this.position;
    }
}
