package racinggame.domain;

import racinggame.exception.ExceedNameSizeException;

public class Name {

    private static final int CAR_NAME_MAX_SIZE = 5;

    private String carName;

    public Name(String carName) {
        validateCarNameSize(carName);
        this.carName = carName;
    }

    public void validateCarNameSize(String carName) {
        if (carName.length() > CAR_NAME_MAX_SIZE) {
            throw new ExceedNameSizeException();
        }
    }

    @Override
    public String toString() {
        return carName;
    }

}
