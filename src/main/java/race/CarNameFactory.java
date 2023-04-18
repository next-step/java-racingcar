package race;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameFactory {
    private static final String DEFAULT_DELIMITER = ",";

    public static List<CarName> makeCarNames(String str) {
        String[] tokens = str.split(DEFAULT_DELIMITER);
        return Arrays.stream(tokens)
                .map(CarName::new)
                .collect(Collectors.toList());
    }
}
