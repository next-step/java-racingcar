package racingcar.car;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.common.ExceptionMessage;

public class CarNames {
    private final static String NAME_VALUE_PATTERN = "[^,]+([,][^,]+)*";
    private final static String DELIMITER = ",";
    private List<CarName> names;

    private CarNames(String nameValue) {
        validate(nameValue);

        this.names = Stream.of(nameValue.split(DELIMITER))
                .map(name -> CarName.newInstance(name))
                .collect(Collectors.toList());
    }

    private void validate(String nameValue) {

        if (!Pattern.matches(NAME_VALUE_PATTERN, nameValue)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_CAR_NAMES.buildMessage(nameValue));
        }
    }

    public static CarNames newInstance(String nameValue) {
        return new CarNames(nameValue);
    }

    public List<CarName> getNames() {
        return names;
    }
}
