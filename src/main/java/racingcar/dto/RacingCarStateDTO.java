package racingcar.dto;

import racingcar.RacingCar;

public final class RacingCarStateDTO {
    final int carNo;
    public final int position;

    public RacingCarStateDTO(RacingCar racingCar) {
        this.carNo = racingCar.getCarNo();
        this.position = racingCar.getPosition();
    }
}
