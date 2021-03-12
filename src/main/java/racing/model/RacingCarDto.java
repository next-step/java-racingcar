package racing.model;

import java.util.Objects;

public class RacingCarDto {

    /**
     * Contoller에서 ResultView로 이동하는 데이터 전송 객체
     */
    private final String racingCarName;
    private final Position position;

    public RacingCarDto(String racingCarName, Position position) {
        this.racingCarName = racingCarName;
        this.position = position;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarDto that = (RacingCarDto) o;
        return Objects.equals(racingCarName, that.racingCarName) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarName, position);
    }
}
