package step5;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName.isBlank()) {
            throw new RuntimeException("자동차의 이름은 공백일 수 없다.");
        }
        if (carName.length() > 5) {
            throw new RuntimeException("자동차의 이름은 5자를 초과할 수 없다.");
        }
    }

    String getCarName() {
        return this.carName;
    }
}
