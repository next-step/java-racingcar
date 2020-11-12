package StringInputCalcualtor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class SimpleCalculator {

    private final Map<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>> operatorMap = new HashMap<>();

    public SimpleCalculator() {
        operatorMap.put("+", this::add);
        operatorMap.put("-", this::subtract);
        operatorMap.put("*", this::multiply);
        operatorMap.put("/", this::divide);
    }

    public BigDecimal operate(String operator, BigDecimal a, BigDecimal b){
        return operatorMap.get(operator).apply(a,b);
    }

    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        return a.divide(b, RoundingMode.FLOOR);
    }

    public BigDecimal operate(List<String> operators, List<BigDecimal> operands) {
        Iterator<String> operatorIterator = operators.iterator();
        return operands
                .stream()
                .reduce((a, b) -> operate(operatorIterator.next(), a, b))
                .orElseThrow(() -> new RuntimeException("사칙연산에 실패 하였습니다."));
    }
}
