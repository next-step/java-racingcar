package edu.nextstep.racingcar.step2;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CalculatorUtils {

    private static final String SPACE_STRING = " ";
    private static final String EMPTY_STRING = "";
    private static final String CALCULATE_STRING = "[+\\-*/]";

    private String source;
    private Queue<Long> calculateValues = new LinkedBlockingQueue<>();
    private Queue<CalculateCode> calculateStrings = new LinkedBlockingQueue<>();

    public void setSource(String source) {
        checkValueOfNullOrEmpty(source);

        this.source = source;
        calculateValues = new LinkedBlockingQueue<>();
        calculateStrings = new LinkedBlockingQueue<>();
    }

    public Long calculate() {
        parseSource(source);

        Long first = calculateValues.poll();
        Long second = calculateValues.poll();
        Long result = 0L;

        for (CalculateCode calculateString : calculateStrings) {
            result = calculateForPartial(first, second, calculateString);

            first = result;
            second = getSecondValue();
        }

        return result;
    }

    private Long getSecondValue() {
        if (!calculateValues.isEmpty()) {
            return calculateValues.poll();
        }

        return 0L;
    }

    private Long calculateForPartial(Long first, Long second, CalculateCode calculateCode) {
        switch (calculateCode) {
            case ADD:
                return addition(first, second);
            case SUB:
                return subtraction(first, second);
            case MULTI:
                return multiplication(first, second);
            case DIV:
                return division(first, second);
            default:
                throw new BusinessException(BusinessError.INVALID_CALCULATE_STRING);
        }
    }

    private void parseSource(String source) {

        String[] values = source.split(SPACE_STRING);

        IntStream.range(0, values.length).forEach(idx -> {

            checkValueOfNullOrEmpty(values[idx]);

            if (idx % 2 == 0) {
                checkNumber(values[idx]);
                calculateValues.add(Long.valueOf(values[idx]));
                return;
            }

            checkCalculateString(values[idx]);
            calculateStrings.add(CalculateCode.findByValue(values[idx]));
        });

        if (calculateStrings.size() + 1 != calculateValues.size()) {
            throw new BusinessException(BusinessError.INVALID_VALUE);
        }
    }

    public Long addition(Long first, Long second) {
        return first + second;
    }

    public Long subtraction(Long first, Long second) {
        return first - second;
    }

    public Long multiplication(Long first, Long second) {
        return first * second;
    }

    public Long division(Long first, Long second) {

        if (second == 0) {
            throw new BusinessException(BusinessError.CAN_NOT_DIVIDE_BY_ZERO);
        }

        return first / second;
    }

    private void checkValueOfNull(Object value) {
        if (value == null) {
            throw new BusinessException(BusinessError.INVALID_VALUE);
        }
    }

    private void checkValueOfNullOrEmpty(String value) {
        checkValueOfNull(value);

        if (value.equals(EMPTY_STRING)) {
            throw new BusinessException(BusinessError.INVALID_VALUE);
        }
    }

    private void checkNumber(String value) {
        try {
            Long.valueOf(value);
        } catch (NumberFormatException e) {
            throw new BusinessException(BusinessError.INVALID_VALUE);
        }
    }

    private void checkCalculateString(String value) {
        Pattern pattern = Pattern.compile(CALCULATE_STRING);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new BusinessException(BusinessError.INVALID_CALCULATE_STRING);
        }
    }
}
