package race;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {
    private static final String DEFAULT_DELIMITER = ",";

    public static Cars makeCars(String str, MoveStrategy moveStrategy) {
        return new Cars(makeCarNameList(str), moveStrategy);
    }

    private static List<CarName> makeCarNameList(String str) {
        String[] tokens = str.split(DEFAULT_DELIMITER);

        return Arrays.stream(tokens)
                .map(CarName::new)
                .collect(Collectors.toList());
    }
}
