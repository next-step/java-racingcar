package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculator {

    int resultMethod(String cal, String method) {
        int splitNum, splitNum2;
        int result = 0;
        String reg = "[+*/-]";
        String[] split = cal.split(reg);
        splitNum = Integer.parseInt(split[0]);
        splitNum2 = Integer.parseInt(split[1]);
        if (method.equals("+")) {
            result = splitNum + splitNum2;
        } else if (method.equals("-")) {
            result = splitNum - splitNum2;
        } else if (method.equals("*")) {
            result = splitNum * splitNum2;
        } else if (method.equals("/")) {
            result = splitNum / splitNum2;
        }
        return result;
    }

    String requestCal(String str) {
        AtomicInteger i = new AtomicInteger(1);

        String reg = "[+*/-]";
        String reg_num = "[0-9]+";

        ArrayList<String> ch = new ArrayList<>(Arrays.asList(str.replaceAll(" ", "").split(reg_num)));
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(str.replaceAll(" ", "").split(reg)));

        Optional<String> c = arr.stream().reduce((a, b) -> {
            double cal = 0;
            double num1 = Double.parseDouble(a);
            double num2 = Double.parseDouble(b);

            cal = Operator.calculate(ch.get(i.get()), num1, num2);
            System.out.printf("%f %s %f = %f %n", num1, ch.get(i.get()), num2, cal);
            i.set(i.get() + 1);
//            cal = Integer.parseInt(String.valueOf(cal));
            return Double.toString(cal);
        });
        System.out.println(c.get());

        return c.get();
    }
}
