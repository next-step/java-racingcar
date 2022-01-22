package calculator;

public class Seperator {

    public Operator operator;
    public Number number;

    public Seperator() {
        operator = new Operator();
        number = new Number();
    }

    public void seperate(String[] lineArr) {
        /*
            ex. 3 + 2 * 5 - 1 + 10
         */
        for (int i = 0; i < lineArr.length; i++) {
            if (i % 2 == 0) {
                // 숫자
                number.addNumber(lineArr[i]);
                continue;
            }
            operator.addOperator(lineArr[i]);
        }
    }
}
