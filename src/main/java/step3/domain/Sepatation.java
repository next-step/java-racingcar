package step3.domain;

import java.util.Arrays;
import java.util.List;

public class Sepatation {

    private static final String SEPARATOR = ",";

    public List<String> nameSeparation(String inputName) {
        return Arrays.asList(inputName.split(SEPARATOR));
    }
}
