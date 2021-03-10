package racing.model;

import java.util.Objects;

public class RacingCarDto {

    /**
     * Contoller에서 ResultView로 이동하는 데이터 전송 객체
     */
    private final String racingCarName;
    private final int position;

    public RacingCarDto(String racingCarName, int position) {
        this.racingCarName = racingCarName;
        this.position = position;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarDto that = (RacingCarDto) o;
        return position == that.position && Objects.equals(racingCarName, that.racingCarName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarName, position);
    }
}
