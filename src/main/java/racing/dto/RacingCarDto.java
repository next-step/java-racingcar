package racing.dto;

import racing.domain.RacingCar;

import java.util.Objects;

public class RacingCarDto {

    private final String name;
    private final int position;

    private RacingCarDto(final String name, final int position) {

        this.name = name;
        this.position = position;
    }

    public static RacingCarDto from(final RacingCar racingCar) {

        return new RacingCarDto(racingCar.getName().getName(), racingCar.getPosition());
    }

    public String getName() {

        return name;
    }

    public int getPosition() {

        return position;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarDto that = (RacingCarDto) o;
        return Objects.equals(name, that.name) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, position);
    }
}
