package step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import step3.utils.ValidationUtils;

public class Names {
    private static final String COMMA = ",";
    private final String names;

    public Names(String names) {
        ValidationUtils.validateEmpty(names);
        this.names = names;
    }

    List<String> getNameList() {
        return Collections.unmodifiableList(Arrays.asList(splitByComma(names)));
    }

    private String[] splitByComma(String names) {
        return names.split(COMMA);
    }
}
