package study.step4.domain;

import study.step4.exception.CarException;

public class CarName {

    private final String name;

    public CarName(String name) {
        String trimmedName = name.trim();
        validate(trimmedName);
        this.name = trimmedName;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (!isValidName(name)) {
            throw new CarException("CarNameError: 자동차 이름은 1자 이상 5자 입니다.");
        }
    }

    private boolean isValidName(String name) {
        int length = name.length();
        return length >= 1 && length <= 5;
    }

}
