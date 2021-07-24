package racingcar.domain;

public class Name {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;
    private static final String ERR_MESSAGE = "이름은 5글자가 최대입니다.";

    private String carName;

    private Name(String carName) {
        this.carName = carName;
    }

    public static Name createName(String carName) {
        if(carName.length() >= LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERR_MESSAGE);
        }

        return new Name(carName);
    }

    public String getCarName() {
        return carName;
    }
}
