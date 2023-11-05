package racinggame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Split {

    private static final String DEFAULT_DELIMITER = ",";

    public List<String> toCarNames(String carName) {
        return Arrays.stream(carName.split(DEFAULT_DELIMITER))
                .collect(Collectors.toList());
    }

}
