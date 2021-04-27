package jung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculater {


    public static void main(String[] str) {
        AtomicInteger i = new AtomicInteger(1);
        String strr = "2 + 3 * 4 / 2";

        String reg = "[+*/-]+";
        String reg_num = "[0-9]+";

        ArrayList<String> ch = new ArrayList<>(Arrays.asList(strr.replaceAll(" ", "").split(reg_num)));
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(strr.replaceAll(" ", "").split(reg)));

        Optional<String> c = arr.stream().reduce((a, b) -> {
            int q = Integer.parseInt(a);
            int w = Integer.parseInt(b);
            int cal = 0;
            switch (ch.get(i.get())) {
                case "+":
                    cal = add(q, w);
                    break;
                case "-":
                    cal = min(q, w);
                    break;
                case "*":
                    cal = multi(q, w);
                    break;
                case "/":
                    cal = div(q, w);
                    break;
                default:
                    break;
            }
            i.set(i.get() + 1);
            return String.valueOf(cal);
        });
        System.out.println(c.get());
    }

    private static int add(int x, int y) {
        return x + y;
    }

    private static int min(int x, int y) {
        return x - y;
    }

    private static int multi(int x, int y) {
        return x * y;
    }

    private static int div(int x, int y) {
        return x / y;
    }
};

