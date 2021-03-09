package calculator;

import exception.InvalidOperatorException;
import exception.InvalidValueException;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public String[] splitStringWithBlank(String str) {
        return str.split(" ");
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

    public boolean checkIsNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public boolean checkIsOddNumber(int num) {
        return num % 2 != 0;
    }
}
