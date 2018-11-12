package stringAddCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalcTest {
    private StringAddCalc carc;

    @Before
    public void setUp() throws Exception {
        carc = new StringAddCalc();
    }

    @Test
    public  void 리턴_0_NULL() {
        String str = "";
        int n = carc.StringToNumber(str);
        assertThat(n).isEqualTo(0);
    }

    @Test
    public  void 숫자하나입력() {
        String str = "1";
        int n = carc.StringToNumber(str);
        assertThat(n).isEqualTo(1);
    }

    @Test
    public void 구분자_쉼표or콜론_덧셈() {
        String str = "1,2:3";
        int n = carc.StringToNumber(str);
        assertThat(n).isEqualTo(6);
    }

    @Test
    public void 커스텀구분자() {
        String str = "//;\1;2;3";
        int n = carc.StringToNumber(str);
        assertThat(n).isEqualTo(6);
    }
}
