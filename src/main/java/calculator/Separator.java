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
            addValue(lineArr, i);
        }
    }

    public void addValue(String[] lineArr, int index) {
        if (index % 2 == 0) {
            number.addNumber(lineArr[index]);
        } else {
            operator.addOperator(lineArr[index]);
        }
    }

    public Number getNumberInstance() {
        return number;
    }

    public Operator getOperatorInstance() {
        return operator;
    }
}
