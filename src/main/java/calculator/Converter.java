package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public List<Integer> convert(List<String> numberCandidates) {
        try {
            List<Integer> numbers = numberCandidates.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            checkHasNegativeNumber(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만 입력 가능합니다.");
        }
    }

    private void checkHasNegativeNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isNegative)) {
            throw new RuntimeException("음수는 입력 불가능합니다.");
        }
    }

    private boolean isNegative(int number) {
        return number < 0;
    }
}
