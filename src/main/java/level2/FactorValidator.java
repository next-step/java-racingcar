package level2;

import java.util.Arrays;

public class FactorValidator {

    public void isNotEmptyParameter(String input) {
        if(input == null || input.isBlank()) throw new IllegalArgumentException();
    }

    public boolean isValidParameter(String input) {
        String[] inputs = input.split(" ");

        long count = Arrays.stream(inputs).filter(i -> i.matches("-?\\d+?") == false)
                .filter(i ->Arrays.stream(Operator.values()).noneMatch(o-> o.isEqualTo(i))).count();

        if(count > 0) throw new IllegalArgumentException();

        return true;
    }
}
