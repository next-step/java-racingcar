package racing.domain;

public class CarName {

    private final String carName;

    public CarName(final String carName) {

        validate(carName);
        this.carName = carName;
    }

    private void validate(final String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 필수값입니다.");
        }
    }

    public String getCarName() {

        return carName;
    }
}
