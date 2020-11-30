package calculator;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {

    @Test
    public void unmodifiableMapTest() {
        Map<String, Operator> testMap = new HashMap<>();
        testMap.put("+", Operator.PLUS);
        testMap.put("-", Operator.MINUS);

        Map<String, Operator> unmodifiableMap = Collections.unmodifiableMap(testMap);

        assertEquals(Operator.PLUS, unmodifiableMap.get("+"));
        assertEquals(Operator.MINUS, unmodifiableMap.get("-"));
    }

    @Test
    void OperatorGet() {
        assertEquals(Operator.getOperator("+"), Operator.PLUS);
        assertEquals(Operator.getOperator("-"), Operator.MINUS);
        assertEquals(Operator.getOperator("*"), Operator.MULTIPLE);
        assertEquals(Operator.getOperator("/"), Operator.DIVIDE);
    }
}
