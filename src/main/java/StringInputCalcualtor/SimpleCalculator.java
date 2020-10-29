package StringInputCalcualtor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class SimpleCalculator {

    private Map<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>> operatorMap = new HashMap<>();

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
}
