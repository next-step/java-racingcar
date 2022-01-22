package calculator;

public class Separator {
    private Number number;
    private Operator operator;

    public Separator() {
        number = new Number();
        operator = new Operator();
    }

    public void separate(String[] lineArr) {
        for (int i = 0; i < lineArr.length; i++) {
            if (i % 2 == 0) {
                number.addNumber(lineArr[i]);
            } else {
                operator.addOperator(lineArr[i]);
            }
        }
    }

    public Number getNumberInstance() {
        return number;
    }

    public Operator getOperatorInstance() {
        return operator;
    }
}
