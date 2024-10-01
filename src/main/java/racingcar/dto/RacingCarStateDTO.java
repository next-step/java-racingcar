package racingcar.dto;

public final class RacingCarStateDTO {
    final int carNo;
    public final int position;

    public RacingCarStateDTO(int carNo, int position) {
        this.carNo = carNo;
        this.position = position;
    }
}
