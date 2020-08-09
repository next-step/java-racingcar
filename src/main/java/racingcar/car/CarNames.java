package racingcar.car;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarNames {
    private final static String nameValuePattern = "[^,]+([,][^,]+)*";
    private List<CarName> names;

    private CarNames(String nameValue) {
        validate(nameValue);

        this.names = Stream.of(nameValue.split(","))
                .map(name -> CarName.newInstance(name))
                .collect(Collectors.toList());
    }

    private void validate(String nameValue) {

        if (!Pattern.matches(nameValuePattern, nameValue)) {
            throw new IllegalArgumentException("[" + nameValue + "]잘못된 입력입니다.");
        }
    }

    public static CarNames newInstance(String nameValue) {
        return new CarNames(nameValue);
    }

    public List<CarName> getNames() {
        return names;
    }
}
