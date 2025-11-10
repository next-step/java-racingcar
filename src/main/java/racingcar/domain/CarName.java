package racingcar.domain;

public record CarName(String value) {

    public CarName {
        if (value == null) {
            throw new IllegalArgumentException("자동차 이름은 null일 수 없습니다.");
        }
    }
}
