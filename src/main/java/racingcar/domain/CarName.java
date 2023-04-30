package racingcar.domain;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new RuntimeException("5자 이상의 이름은 입력할 수 없습니다.");
        }
    }
}
