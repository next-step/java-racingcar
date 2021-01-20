package calculator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CalculationInfo {
    private int dividend;
    private int divisor;
    private Operator operator;
}
