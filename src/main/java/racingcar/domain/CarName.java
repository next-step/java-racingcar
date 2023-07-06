package racingcar.domain;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5 이하여야 합니다.");
        }
    }

    private void validateEmpty(String carName) {
        if (carName == null || carName.isBlank()){
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 다시 입력해주세요");
        }
    }
}
