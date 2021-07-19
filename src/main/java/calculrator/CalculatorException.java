package calculrator;

public class CalculatorException {

    final String[] expression = {"+","-","*","/"};


    public void checkException(String expression, int lastValue){
        if(expression == null || expression.isEmpty()) throw new IllegalArgumentException("연산 수식이 빈값입니다.");
        if(lastValue == 0) throw new IllegalStateException("0으로 나눗셈은 불가능합니다.");
    }


}
