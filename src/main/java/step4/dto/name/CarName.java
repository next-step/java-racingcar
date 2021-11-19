package step4.dto.name;

import step4.common.MyException;
import step4.common.Number;

import java.util.Arrays;
import java.util.Objects;

public class CarName {
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    private final CarNameGroup carNameGroup;

    public CarName(String carName) {
        textNullOrEmptyThrow(carName);

        String[] names = carName.split(DELIMITER);

        validationNames(names);

        carNameGroup = new CarNameGroup(Arrays.asList(names));
    }

    public CarNameGroup carNameGroup() {
        return carNameGroup;
    }

    private void textNullOrEmptyThrow(String text) {
        if(Objects.isNull(text) || text.trim().equals(EMPTY)) {
            throw new IllegalArgumentException(MyException.NAME_IS_NOT_NULL.getMessage());
        }
    }

    private void validationNames(String[] names) {
        for (String name : names) {
            notValidNameThrow(name);
        }
    }

    private void notValidNameThrow(String name) {
        textNullOrEmptyThrow(name);

        if(name.length() < Number.ZERO.getValue() || name.length() > Number.FIVE.getValue()) {
            throw new IllegalArgumentException(MyException.INVALID_NAME_LENGTH.getMessage());
        }
    }
}
