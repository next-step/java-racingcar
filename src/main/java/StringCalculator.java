import operator.*;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {
    Map<String, Operator> operationMap;
    public int getMathAnswer(String params) {
        if (params == null || params.length() == 0) {
            throw new IllegalArgumentException("Unvalid parameter");
        }
        String[] strings = params.split(" ");
        setCharacterOperatorMap();
        int calculate = calculate(strings);
        return calculate;
    }

    private void setCharacterOperatorMap() {
        operationMap = new HashMap<>();
        operationMap.put("+", new Add());
        operationMap.put("-", new Subtract());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());
    }

    private int calculate(String[] strings) {
        int index = 1;
        int result = Integer.parseInt(strings[0]);
        while (index < strings.length) {
            if (!operationMap.containsKey(strings[index])) {
                Integer isInteger = Integer.valueOf(strings[index]);
            }
            if (operationMap.containsKey(strings[index])) {
                Operator operator = operationMap.get(strings[index]);
                result = operator.operation(result, Integer.parseInt(strings[index +1]));
                index += 1;
            }
            index++;
        }
        return result;
    }
}
