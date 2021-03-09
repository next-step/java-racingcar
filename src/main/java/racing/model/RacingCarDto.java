package racing.model;

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
}
