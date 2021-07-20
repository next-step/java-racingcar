package edu.nextstep.racingcar.step2;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CalculatorUtils {

    private String source;
    private Queue<Long> calculateValues = new LinkedBlockingQueue<>();
    private Queue<String> calculateStrings = new LinkedBlockingQueue<>();

    public void setSource(String source) {
        this.source = source;
        calculateValues = new LinkedBlockingQueue<>();
        calculateStrings = new LinkedBlockingQueue<>();
    }

    public Long calculate() {
        parseSource();

        Long first = calculateValues.poll();
        Long second = calculateValues.poll();

        for (String calculateString : calculateStrings) {

            switch (calculateString) {
                case "+":
                    first = addition(first, second);
                    break;
                case "-":
                    first = subtraction(first, second);
                    break;
                case "*":
                    first = multiplication(first, second);
                    break;
                case "/":
                    first = division(first, second);
                    break;
            }

            if (!calculateValues.isEmpty()) {
                second = calculateValues.poll();
            }
        }

        return first;
    }

    private void parseSource() {
        checkValueOfNullOrEmpty(this.source);

        String[] values = this.source.split(" ");

        IntStream.range(0, values.length).forEach(idx -> {

            checkValueOfNullOrEmpty(values[idx]);

            if (idx % 2 == 0) {
                checkNumber(values[idx]);
                calculateValues.add(Long.valueOf(values[idx]));
            } else {
                checkCalculateString(values[idx]);
                calculateStrings.add(values[idx]);
            }
        });

        if (calculateStrings.size() + 1 != calculateValues.size()) {
            throw new IllegalArgumentException();
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

        if (first == 0) {
            throw new IllegalArgumentException();
        }

        return first / second;
    }

    private void checkValueOfNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkValueOfNullOrEmpty(String value) {
        checkValueOfNull(value);

        if (value.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumber(String value) {
        try {
            Long.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCalculateString(String value) {
        Pattern pattern = Pattern.compile("[+\\-*/]");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}
