package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formular {

    private final static String SPLIT_EMPTY_SPACE_NUMBER = " ";
    private List<String> splitedFormular;

    public Formular(String expressions) {
        this.splitedFormular = new ArrayList<>(Arrays.asList(expressions.split(
            SPLIT_EMPTY_SPACE_NUMBER)));
    }

    public List<String> getSplitedFormular() {
        return splitedFormular;
    }

}
