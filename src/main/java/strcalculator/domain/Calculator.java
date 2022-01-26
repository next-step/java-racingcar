package strcalculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Calculator {

    private  String[] numberList;
    private  String[] operandList;
    private int leftNumber = 0;
    private int rightNumber = 0;

    public Calculator(String[] numberList, String[] operandList) {
        this.numberList = numberList;
        this.operandList = operandList;
    }
    private final Map<String, Supplier<Integer>> operandDivision = new HashMap<>();
    {
        operandDivision.put("+", ()-> leftNumber+rightNumber);
        operandDivision.put("-", ()-> leftNumber-rightNumber);
        operandDivision.put("*", ()-> leftNumber*rightNumber);
        operandDivision.put("/", ()-> leftNumber/rightNumber);
    }

    public void calculate() {
        leftNumber = Integer.parseInt(numberList[0]);
        for (int i = 1; i < operandList.length; i++) {
            rightNumber = Integer.parseInt(numberList[i]);
            String operator = operandList[i];
            leftNumber = operandDivision.get(operator).get();
        }
        System.out.println(leftNumber);
    }

}
