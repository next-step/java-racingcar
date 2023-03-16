package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Queue;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 8 / 5 * 2 ", "20 - 5 / 2 * 2 "})
    void caculator(String input) throws Exception {
        Calculator ca = new Calculator();
        int result = ca.excute(input);
        System.out.println(result);
    }

    @Test
    void caculator_숫자리스트_추출_확인() throws Exception {
        Calculator ca = new Calculator();
        String[] list = {"1", "+", "2", "-"};
        Queue<Integer> result = ca.numberGroups(list);
        System.out.println(result);
    }

    @Test
    void caculator_영산자리스트_추출_확인() throws Exception {
        Calculator ca = new Calculator();
        String[] list = {"1", "+", "2", "-"};
        Queue<String> result = ca.separatorGroups(list);
        System.out.println(result);
    }

}
