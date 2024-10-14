package racingcar.dto;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarState;

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
        return new RacingCarStateDTO(racingCar.getName(), racingCar.getCarNo(), racingCar.getPosition());
    }

    public static RacingCarStateDTO valueOf(RacingCarState state) {
        return new RacingCarStateDTO(state.getCarName(), state.getCarNo(), state.getPosition());
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getPosition() {
        return this.position;
    }
}
