package racing.vehicle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private final List<CarName> names;
    private static final String NAMES_DELIMITER_REGEX = ",";

    public CarNames(String carNamesMessage) {
        validateCarNames(carNamesMessage);
        this.names = parseCarNamesMessage(carNamesMessage).stream()
                .map(CarName::new).collect(Collectors.toList());
    }

    private void validateCarNames(String carNamesMessage) {
        if (carNamesMessage == null) {
            throw new IllegalArgumentException("Car names message cannot be null.");
        }
    }

    private List<String> parseCarNamesMessage(String carNamesMessage) {
        return Arrays.asList(carNamesMessage.split(NAMES_DELIMITER_REGEX));
    }

    public List<CarName> getNames() {
        return Collections.unmodifiableList(this.names);
    }

    public int getSize() {
        return this.names.size();
    }
}
