package calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Splitter {
    private String[] arrays;
    private List<Integer> integers;
    private List<CalculatorSign> signs;

    protected Splitter() {
    }

    public Splitter(String data) {
        if (isBlank(data)) {
            throw new IllegalArgumentException(String.format("입력 데이터가 올바르지 않습니다. : [%s] ", data));
        }

        this.arrays = data.split(" ");

        if (!isSupportFormat()) {
            throw new IllegalArgumentException(String.format("입력 데이터가 올바르지 않습니다. : [%s] ", data));
        }

        setIntegers();
        setCalculatorSigns();
    }

    private void setCalculatorSigns() {

        this.signs = IntStream.range(0, arrays.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> CalculatorSign.findByCodeName(arrays[i]))
                .collect(Collectors.toList());

    }

    private void setIntegers() {
        this.integers = IntStream.range(0, arrays.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Integer.parseInt(arrays[i]))
                .collect(Collectors.toList());
    }

    private boolean isSupportFormat() {
        boolean isCalculatorSign = IntStream.range(0, this.arrays.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(m -> arrays[m])
                .allMatch(sign -> sign.matches("^[*/+-]+$"));


        boolean isNumbers = IntStream.range(0, this.arrays.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(m -> arrays[m])
                .allMatch(number -> number.matches("^[0-9]+$"));

        return isCalculatorSign && isNumbers;
    }

    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public List<Integer> getIntegers() {
        return this.integers;
    }

    public List<CalculatorSign> getSigns() {
        return this.signs;
    }
}
