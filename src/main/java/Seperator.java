import java.util.ArrayList;
import java.util.List;

public class Seperator {

    private Operator operator;
    private Number number;

    public Seperator() {
        operator = new Operator();
        number = new Number();
    }

    public static void grouping(String[] lineArr, Operator operator, Number number) {
        /*
            ex. 3 + 2 * 5 - 1 + 10
         */
        for (int i = 0; i < lineArr.length; i++) {
            if (i % 2 == 0) {
                // 숫자
                number.addNumber(Integer.valueOf(lineArr[i]));
                continue;
            }
            operator.addOperator(lineArr[i]);
        }
    }
}
