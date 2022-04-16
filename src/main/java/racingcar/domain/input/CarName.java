package racingcar.domain.input;

public class CarName {

    private static final String REQUIRED_CAR_NAME_MESSAGE = "자동차 이름은 필수로 입력해야합니다.";
    private static final String MAX_CAR_NAME_MESSAGE = "자동차의 이름은 5자를 초과할 수 없습니다.";
    private static final int MAX_LENGTH_CAR_NAME = 5;
    private String carName;

    public CarName(String carName) {
        if (isNullOrBlank(carName)) {
            throw new IllegalArgumentException(REQUIRED_CAR_NAME_MESSAGE);
        }
        if (isOverMaxLength(carName)) {
            throw new IllegalArgumentException(MAX_CAR_NAME_MESSAGE);
        }
        this.carName = carName;
    }

    private boolean isOverMaxLength(String carName) {
        return carName.length() > MAX_LENGTH_CAR_NAME;
    }

    private boolean isNullOrBlank(String carName) {
        return carName == null || carName.isBlank();
    }

    public String getCarName() {
        return this.carName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CarName)) {
            return false;
        }
        CarName cn = (CarName) obj;
        return cn.carName.equals(carName);
    }
}
