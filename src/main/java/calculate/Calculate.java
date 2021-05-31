package calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculate {

    int resultMethod(String cal, String method) {
        int split_num1, split_num2;
        int result=0;
        String reg = "[+*/-]";
        String[] split = cal.split(reg);
        System.out.println(split[0]);
        System.out.println(split[1]);
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        if (method == "+") {
            result = split_num1 + split_num2;
        } else if (method == "-") {
            result = split_num1 - split_num2;
        } else if (method == "*") {
            result = split_num1 * split_num2;
        } else if (method == "/") {
            result = split_num1 / split_num2;
        }
        return result;
    }

    public int add(String cal) {
        int result = 0;
        result = resultMethod(cal, "+");
        return result;
    }

    public int sub(String cal, int resultCheckNumber) {
        int result = 0;
        result = resultMethod(cal, "-");
        return result;
    }

    public int dvide(String cal, int resultCheckNumber) {
        int result = 0;
        result = resultMethod(cal, "/");
        return result;
    }

    public int dvidmultyplee(String cal, int resultCheckNumber) {
        int result = 0;
        result = resultMethod(cal, "/");
        return result;
    }

    String requestCal(String calString) {
        AtomicInteger i = new AtomicInteger(1);
        String str = "2 + 3 * 4 / 2";

        String reg = "[+*/-]";
        String reg_num = "[0-9]+";

        ArrayList<String> ch = new ArrayList<>(Arrays.asList(str.replaceAll(" ", "").split(reg_num)));
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(str.replaceAll(" ", "").split(reg)));

        Optional<String> c = arr.stream().reduce((a, b) -> {
            double cal = 0;
            double num1 = Double.parseDouble(a);
            double num2 = Double.parseDouble(b);
            CalculateEnum method = new CalculateEnum();
            cal = method.calculate(ch.get(i.get()), num1, num2);
            System.out.printf("%f %s %f = %f %n", num1, ch.get(i.get()), num2, cal);
            i.set(i.get() + 1);
//            cal = Integer.parseInt(String.valueOf(cal));
            return Double.toString(cal);
        });
        System.out.println(c.get());

        return c.get();
    }
}
