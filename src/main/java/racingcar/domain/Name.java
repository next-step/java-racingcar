package racingcar.domain;

public class Name {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;
    private String carName;

    private Name(String carName) {
        this.carName = carName;
    }

    public static Name validateByName(String carName) {
        if(carName.length() >= LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자가 최대입니다.");
        }
        return new Name(carName);
    }

}
