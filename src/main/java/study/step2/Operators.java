package study.step2;

import study.step2.common.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operators {

    private List<String> operators;

    public Operators(String [] operators) {
        this.operators = convertToStringList(operators);
    }

    private List<String> convertToStringList(String[] operators) {

        return Arrays.stream(operators)
                .filter(value-> isOperator(value))
                .collect(Collectors.toList());
    }

    private boolean isOperator(String value) {
        return !StringUtil.isNumber(value);
    }

    public List<String> getOperators() {
        return this.operators;
    }
}
