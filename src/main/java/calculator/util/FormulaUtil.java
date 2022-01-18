package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormulaUtil {

    private FormulaUtil(){}

    public static List<String> split(String formular) {
        return new ArrayList<>(Arrays.asList(formular.split(" ")));
    }
}
