import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int plus(String input) {
        String[] split = input.split(" ");

        int result = 0;
        if (split.length > 2) result = Integer.parseInt(split[0]);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.equalsIgnoreCase("+")) {
                result += Integer.parseInt(split[i+1]);
            }
        }
        return result;
    }

    public int minus(String input) {
        String[] split = input.split(" ");

        List<Integer> operands = Arrays.stream(split)
                .filter(e -> !e.equals("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (operands.size() == 0) throw new IllegalArgumentException("잘못된 입력 값");
        return operands.stream().reduce((a, b) -> a - b).get();
    }

    public int multiply(String input) {
        List<String> operand = Arrays.stream(input.split(" "))
                .filter(e -> !e.equals("*"))
                .collect(Collectors.toList());

        return operand.stream()
                .map(Integer::parseInt)
                .reduce((a, b) -> a * b)
                .orElseThrow(IllegalArgumentException::new);
    }
}
