package calculator;

import java.util.Scanner;

public class Calculator {


    /*
     *  @param String[] strArr String 배열
     *  입력받은 값을 사칙연산을 통해 계산한다.
     * */
    public int calculate(String str) {
        String[] strArr = StringUtil.splitInput(str);

        ValidationUtil.validateInput(strArr);
        return execute(strArr);
    }


    public int execute(String[] strArr) {
        int total = 0;
        total += Integer.parseInt(strArr[0]);
        for (int i = 1; i < strArr.length -1; i += 2) {
            int num = Integer.parseInt(strArr[i+1]);
            total = Operator.calculation(strArr[i], total, num);
        }
        return total;
    }


}
