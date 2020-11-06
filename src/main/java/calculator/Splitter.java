package calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Splitter {
    private String[] arrays;
    private List<Integer> calculatorNumbers;
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
                .filter(index -> isOdd(index))
                .mapToObj(index -> CalculatorSign.findByCodeName(arrays[index]))
                .collect(Collectors.toList());
    }

    private void setIntegers() {
        this.calculatorNumbers = IntStream.range(0, arrays.length)
                .filter(index -> !isOdd(index))
                .mapToObj(index -> Integer.parseInt(arrays[index]))
                .collect(Collectors.toList());
    }

    private boolean isSupportFormat() {
        return isSopportCalculatorSing() && isSupportNumbers();
    }

    private boolean isSupportNumbers() {
        return IntStream.range(0, this.arrays.length)
                .filter(index -> !isOdd(index))
                .allMatch(index -> isNumberFormat(index));
    }

    private boolean isNumberFormat(int index){
        return this.arrays[index].matches("^[0-9]+$");
    }

    private boolean isSopportCalculatorSing() {
        return IntStream.range(0, this.arrays.length)
                .filter(index -> isOdd(index))
                .allMatch(index -> isSignFormat(index));
    }

    private boolean isSignFormat(int index) {
        return this.arrays[index].matches("^[*/+-]+$");
    }

    private boolean isOdd(int index) {
        return index%2 == 1;
    }

    private boolean isBlank(String input) {
        return Objects.isNull(input) || input.trim().isEmpty();
    }

    public List<Integer> getCalculatorNumbers() {
        return this.calculatorNumbers;
    }

    public List<CalculatorSign> getSigns() {
        return this.signs;
    }
}
