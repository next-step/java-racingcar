package kr.calculator;


import org.junit.BeforeClass;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    public static StringCalculator sc;

    @BeforeClass
    public static void beforeClassFunction(){
        sc =  new StringCalculator();;
    }

    @Test
    public void 더하기() {
        int res = sc.calcualtor("2 + 3");

        assertThat(res).isEqualTo(5);
    }

    @Test
    public void 나누기() {
        int res = sc.calcualtor("2 / 2");

        assertThat(res).isEqualTo(1);
    }

    @Test
    public void 곱하기() {
        int res = sc.calcualtor("5 * 2");

        assertThat(res).isEqualTo(10);
    }

    @Test
    public void 뺴기() {
        int res = sc.calcualtor("2 - 1");

        assertThat(res).isEqualTo(1);
    }


    @Test
    public void 결과구하기() {
        String testCase = "2 + 3 * 4 / 2";

        assertThat(sc.calcualtor(testCase)).isEqualTo(10);
    }
}