package racingcar.dto;

import racingcar.RacingCar;

public final class RacingCarStateDTO {
    public final int carNo;
    public final int position;

    private RacingCarStateDTO(int carNo, int position) {
        this.carNo = carNo;
        this.position = position;
    }

    public static RacingCarStateDTO fromRacingCar(RacingCar racingCar) {
        return new RacingCarStateDTO(racingCar.getCarNo(), racingCar.getPosition());
    }
}
