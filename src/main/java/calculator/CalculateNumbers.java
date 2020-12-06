package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculateNumbers {
    private static final String VALID_EMPTY_NUMBERS_MESSAGE = "입력 값이 없습니다.";
    private static final String VALID_MIN_SIZE_MESSAGE = "공백을 기준으로 최소 3개 이상 입력바랍니다.";
    private static final int MIN_SIZE = 3;
    private final List<CalculateNumber> numbers;

    public CalculateNumbers(String[] numbers) {
        validNumber(numbers);
        this.numbers = mapCaculateNumber(numbers);
    }

    private List<CalculateNumber> mapCaculateNumber(String[] numbers) {
        List<CalculateNumber> calculateNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i += 2) {
            calculateNumbers.add(new CalculateNumber(numbers[i]));
            calculateNumbers.add(new CalculateNumber(numbers[i + 2]));
        }
        return calculateNumbers;
    }

    private void validNumber(String[] numbers) {
        validEmpty(numbers);
        validMinSize(numbers);
    }

    private void validEmpty(String[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException(VALID_EMPTY_NUMBERS_MESSAGE);
        }
    }

    private void validMinSize(String[] numbers) {
        if (numbers.length > 0 && numbers.length < MIN_SIZE) {
            throw new IllegalArgumentException(VALID_MIN_SIZE_MESSAGE);
        }
    }
}
