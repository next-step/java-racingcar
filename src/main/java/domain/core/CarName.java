package domain.core;

import domain.core.exception.CarNameExceedFiveCharacterException;

import static domain.core.GameOptions.MAX_DIGITS;

/**
 * 자동차 이름 원시값 포장
 */
public class CarName {
    private final String name;

    public CarName(String name) {
        validateCarNameLessThanFiveDigits(name);
        this.name = name;
    }

    private void validateCarNameLessThanFiveDigits(String name) {
        if (name.length() > MAX_DIGITS) {
            throw new CarNameExceedFiveCharacterException();
        }
    }

    public String getName(){
        return name;
    }
}
