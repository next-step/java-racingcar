package step3.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private static final String DELIMITER = ",";

    private List<Name> values;

    public Names(String input) {
        this.values = initNames(splitByDelimiter(input));
    }

    private String[] splitByDelimiter(String input) {
        return input.split(DELIMITER);
    }

    private List<Name> initNames(String[] splits) {
        return Arrays.stream(splits)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> getValues() {
        return values;
    }
}
