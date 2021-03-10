package calculator;

import calculator.exception.InvalidOperatorException;
import calculator.exception.InvalidValueException;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public String[] splitString(String str) {
        return str.split(" ");
    }

    public boolean checkIsOddNumber(int num) {
        return num % 2 != 0;
    }

    public void checkInvalidValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new InvalidValueException();
        }
    }

    public void checkInvalidOperator(String value) {
        List<String> operationTypes = new ArrayList<>();
        operationTypes.add("+");
        operationTypes.add("-");
        operationTypes.add("/");
        operationTypes.add("*");

        if (!operationTypes.contains(value)) {
            throw new InvalidOperatorException();
        }
    }
}
