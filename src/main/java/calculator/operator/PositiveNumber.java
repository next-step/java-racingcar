package calculator.operator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PositiveNumber {

    private int value;

    public PositiveNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    public PositiveNumber plus(PositiveNumber number) {
        this.value += number.value;
        return new PositiveNumber(value);
    }

    private void validateRange(int number) {
        if (number < 0) {
            throw new OutOfRangeException("[숫자 범위 에러] 음수는 포함될 수 없습니다. number:" + number);
        }
    }

    public static List<PositiveNumber> parseNumberOperators(String[] numbers) {
        return Arrays.stream(numbers)
                .map(PositiveNumber::stringToInt)
                .collect(Collectors.toList());
    }

    static PositiveNumber stringToInt(String numberStr) {
        if (!numberStr.isBlank()) {
            return new PositiveNumber(Integer.parseInt(numberStr));
        }

        return new PositiveNumber(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
