package step2;

import java.math.BigDecimal;
import java.util.List;

public class Numbers {

    private List<BigDecimal> numbers;

    public Numbers(List<BigDecimal> numbers) {
        this.numbers = numbers;
    }

    public BigDecimal get(int index) {
        return numbers.get(index);
    }

}
