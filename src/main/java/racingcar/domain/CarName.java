package racingcar.domain;

public record CarName(String value) {

    public CarName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }
}
