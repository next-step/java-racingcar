package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParser {

    public List<Car> parse(final String nameString) {
        if (!isValid(nameString)) throw new IllegalArgumentException();

        List<String> names = Arrays.asList((nameString).split(","));
        return names.stream().map(Car::new).collect(Collectors.toList());
    }

    private boolean isValid(final String nameString) {
        return (nameString != null && nameString.trim().length() != 0);
    }
}
