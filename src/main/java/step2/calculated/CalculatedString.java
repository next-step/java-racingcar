package step2.calculated;

import step2.numbers.Numbers;
import step2.numbers.StringsToNumbers;
import step2.parsed.Parsed;

import java.util.List;

public class CalculatedString implements Calculated {

    private final Numbers numbers;

    public CalculatedString(Parsed parsed) {
        this(new StringsToNumbers(parsed));
    }

    public CalculatedString(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public int calculatedResult() {
        List<Integer> numbersToCalculated = numbers.numbers();
        return numbersToCalculated.stream()
                .mapToInt(numbers -> numbers)
                .sum();
    }

}

