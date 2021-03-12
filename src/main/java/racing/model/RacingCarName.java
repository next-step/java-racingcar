package racing.model;

public class RacingCarName {

    private final String racingCarName;

    public RacingCarName(String racingCarName) {
        if (racingCarName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }
        if (racingCarName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.racingCarName = racingCarName;
    }

    public String getRacingCarName() {
        return racingCarName;
    }
}
