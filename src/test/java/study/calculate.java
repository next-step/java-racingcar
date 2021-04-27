package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class calculate {

    @ParameterizedTest
    @CsvSource(value = {"2+3:5 ", "2+8:10"}, delimiter = ':')
    void add(String cal, int result) {
        int split_num1, split_num2, sum;
        String[] split = cal.split("[+]");
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        sum = split_num1 + split_num2;
        System.out.println(split_num1 + "+" + split_num2 + "=" + sum);
        assertThat(sum).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"8-2:6 ", "150-3:147"}, delimiter = ':')
    void sub(String cal, int result) {
        int split_num1, split_num2, sum;
        String[] split = cal.split("[-]");
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        sum = split_num1 - split_num2;
        System.out.println(split_num1 + "-" + split_num2 + "=" + sum);
        assertThat(sum).isEqualTo(result);

    }

    @ParameterizedTest
    @CsvSource(value = {"8/2:4 ", "150/3:50"}, delimiter = ':')
    void dvide(String cal, int result) {
        int split_num1, split_num2, sum;
        String[] split = cal.split("[/]");
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        sum = split_num1 / split_num2;
        System.out.println(split_num1 + "/" + split_num2 + "=" + sum);
        assertThat(sum).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"8*2:16 ", "150*3:450"}, delimiter = ':')
    void multyple(String cal, int result) {
        int split_num1, split_num2, sum;
        String[] split = cal.split("[*]");
        split_num1 = Integer.parseInt(split[0]);
        split_num2 = Integer.parseInt(split[1]);
        sum = split_num1 / split_num2;
        System.out.println(split_num1 + "*" + split_num2 + "=" + sum);
        assertThat(sum).isEqualTo(result);
    }

    @CsvSource(value = {"2 + 3 * 4 / 2 :10 "}, delimiter = ':')
    void testCheck(String cal , int result){
        String[] tag = { "+" , "-" , "/" , "*" };
//        String[] num = cal.split();
    }
    @Test
    void cal() {
        AtomicInteger i = new AtomicInteger(1);
        String str = "2 + 3 * 4 / 2";

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
