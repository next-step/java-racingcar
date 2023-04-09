import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}

class StringAddCalculator {

    public static int splitAndSum(String str) {

        if (str == null) { str = "0"; }
        else if (str.equals("") || str.isEmpty()) { str = "0"; }

        int sumValue = 0;

        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);

            for (int i=0; i < tokens.length; i++) {
                if (!(tokens[i].trim().matches("[0-9]"))) {
                    throw new RuntimeException();
                }
                    sumValue = Integer.parseInt(tokens[i].trim()) + sumValue;
                }

            return sumValue;

        } else {

            String[] val = str.split(",|:");

            if (val.length == 1) {
                if (!(val[0].trim().matches("[0-9]"))) {
                    throw new RuntimeException();
                }
                return Integer.parseInt(val[0]);

            } else {
                for (int i=0; i < val.length; i++) {
                    if (!(val[i].trim().matches("[0-9]"))) {
                        throw new RuntimeException();
                    }
                    sumValue = Integer.parseInt(val[i].trim()) + sumValue;
                }
                return sumValue;
            }
        }

    }
}






