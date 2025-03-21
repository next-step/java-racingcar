package racingcar;

public class RacingCarName {

    private final String carName;

    public RacingCarName(String carName) {
        this.carName = carName;
        validate();
    }

    private void validate() {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return carName;
    }
}
