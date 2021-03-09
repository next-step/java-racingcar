package racing.model;

public class RacingCarDto {

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
}
