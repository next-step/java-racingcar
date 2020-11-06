package StringInputCalcualtor;


import lombok.Getter;
import utils.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Getter
public class StringInputClassifier {

    private static final String BLANK_FOR_SPLIT = " ";
    private static final Set<String> AVAILABLE_OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    private static final Pattern DOUBLE_REGEX_PATTERN = Pattern.compile("\\d+(?:\\.\\d+)?");

    private String input;
    private List<BigDecimal> operands = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public void input(String input) {
        this.input = input;
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException("입력값이 없음");
        }
        String[] split = input.split(BLANK_FOR_SPLIT);
        classify(split);
    }

    protected void classify(String[] split) {
        Stream.of(split).forEach(x -> {
            if (isOperator(x)) {
                operators.add(x);
            } else if (isOperand(x)) {
                operands.add(new BigDecimal(x));
            } else {
                throw new IllegalArgumentException("올바르지 않은 연산자 입니다.");
            }
        });
    }

    protected boolean isOperand(String possibleOperator) {
        Matcher regexMatcher = DOUBLE_REGEX_PATTERN.matcher(possibleOperator);
        return regexMatcher.find();
    }

    protected boolean isOperator(String possibleOperand) {
        return AVAILABLE_OPERATORS.contains(possibleOperand);
    }
}
