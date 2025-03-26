package racingcar.domain.dto;

public class CarDto {
    private final int position;

    public CarDto(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
