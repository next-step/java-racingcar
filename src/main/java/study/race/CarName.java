package study.race;

public class CarName {

    private int maxCarNameLength = 5;

    private String carName;

    public CarName(String carName) {
        validateName(carName);
        this.carName = carName;
    }

    public String getName() {
        return this.carName;
    }

    private void validateName(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalStateException("자동차 이름을 입력해주세요.");
        }

        if (carName.length() > maxCarNameLength) {
            throw new IllegalStateException("자동차 이름은 1~5자만 가능합니다.");
        }
    }
}
