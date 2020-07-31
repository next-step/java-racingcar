package step2;


import step2.enums.Operator;

public class StringCalculator {

    public Integer calculate(String expression) {
        StringCalculatorVO stringCalculatorVO = new StringCalculatorVO(expression);

        Integer[] numberElements = stringCalculatorVO.getNumberElements();
        String[] operatorElements = stringCalculatorVO.getOperatorElements();

        Integer result = numberElements[0];

        for(int i = 1 ; i < numberElements.length ; i++) {
            Integer number = numberElements[i];

            result = computeWithRightOperator(result,number,operatorElements[i-1]);
        }

        return result;

    }

    private Integer computeWithRightOperator(Integer one, Integer theOther, String operator) {
        return Operator.get(operator).compute(one, theOther);
    }


}
