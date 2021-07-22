package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FIFOCalculator {
    private String rawInput;

    public FIFOCalculator() { }

    public FIFOCalculator(String rawInput) { this.rawInput = rawInput; }

    public void setRawInput(String rawInput) { this.rawInput = rawInput; }

    private void validateInput() {
        if (rawInput == null || rawInput.trim().equals("")) {
            throw new IllegalArgumentException("입력 값이 null 이거나 공백문자입니다.");
        }

        if (!rawInput.replaceAll(" ", "").matches("^[0-9+\\-*/]+$")) {
            throw new IllegalArgumentException("입력 값에 허용되지 않은 기호가 포함되어 있습니다.");
        }
    }

    private String[] tokenizeInput() { return rawInput.split(" "); }

    public int calculate() throws IllegalArgumentException {
        validateInput();

        List<String> tokens = new ArrayList<>(Arrays.asList(tokenizeInput()));
        int accumulator = Integer.parseInt(tokens.remove(0));

        return calculate(tokens, accumulator);
    }

    private int calculate(List<String> tokens, int accumulator) {
        return IntStream.range(0, tokens.size() / 2)
                .reduce(accumulator, (acc, i) -> {
                    Operator operator = Operator.fromString(tokens.get(i * 2));
                    int operand = Integer.parseInt(tokens.get(i * 2 + 1));

                    return operator.applyAsInt(acc, operand);
                });
    }
}
