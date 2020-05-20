package step2;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperatorMapper {
    private final Map<String, Operator> operatorMap;

    private OperatorMapper() {
        operatorMap = Stream.of(Operator.values())
                .collect(Collectors.toMap(operator -> operator.symbol, operator -> operator));
    }

    public static OperatorMapper getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final OperatorMapper INSTANCE = new OperatorMapper();
    }

    /**
     * 주어진 문자열이 사칙연산 연산자가 맞다면 해당하는 연산자 enum객체 반환
     * 
     * @param operator : String, 사칙 연산자 e.g. "+"
     * @return Operator, 해당하는 연산자 enum 객체
     */
    public Operator getOperator(String operator) {
        return operatorMap.get(operator);
    }
}
