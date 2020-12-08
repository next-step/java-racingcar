package step2;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private List<BigDecimal> numbers;

    public Numbers(List<String> text) {
        this.numbers = text.stream()
                .map(NumberUtil::textToBigDecimal)
                .collect(Collectors.toList());
    }

    public BigDecimal get(int index) {
        return numbers.get(index);
    }

}
