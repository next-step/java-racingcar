package calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
public class Calculate {

    public int add(String cal, int resultCheckNumber) {
        int split_num1, split_num2, result;
        String[] split = cal.split("[+]");
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        result = split_num1 + split_num2;
        System.out.println(split_num1 + "+" + split_num2 + "=" + result);

        return result;
    }

    public int sub(String cal, int resultCheckNumber) {
        int split_num1, split_num2, result;
        String[] split = cal.split("[-]");
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        result = split_num1 - split_num2;
        System.out.println(split_num1 + "-" + split_num2 + "=" + result);

        return result;
    }
    public int dvide(String cal, int resultCheckNumber) {
        int split_num1, split_num2, result;
        String[] split = cal.split("[/]");
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        result = split_num1 / split_num2;
        System.out.println(split_num1 + "/" + split_num2 + "=" + result);

        return result;
    }
    public int dvidmultyplee(String cal, int resultCheckNumber) {
        int split_num1, split_num2, result;
        String[] split = cal.split("[*]");
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        result = split_num1 / split_num2;
        System.out.println(split_num1 + "*" + split_num2 + "=" + result);

        return result;
    }

    void requestCal(String calString, int resultCheckNumber ) {
        AtomicInteger i = new AtomicInteger(1);
        String str = calString;

        String reg = "[+*/-]";
        String reg_num = "[0-9]+";

        ArrayList<String> ch = new ArrayList<>(Arrays.asList(str.replaceAll(" ", "").split(reg_num)));
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(str.replaceAll(" ", "").split(reg)));

        Optional<String> c = arr.stream().reduce((a, b) -> {
            int cal = 0;
            System.out.println(a +"," +b);
            switch (ch.get(i.get())) {
                case "+":
                    cal = Integer.parseInt(a) + Integer.parseInt(b);
                    System.out.println(ch.get(i.get()));
                    break;
                case "-":
                    cal = Integer.parseInt(a) - Integer.parseInt(b);
                    System.out.println(ch.get(i.get()));
                    break;
                case "*":
                    cal = Integer.parseInt(a) * Integer.parseInt(b);
                    System.out.println(ch.get(i.get()));
                    break;
                case "/":
                    cal = Integer.parseInt(a) / Integer.parseInt(b);
                    System.out.println(ch.get(i.get()));
                    break;
                default:
                    break;
            }
            i.set(i.get() + 1);
            return String.valueOf(cal);
        });
        System.out.println(c.get());
    }
}
