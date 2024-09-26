package caculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.*;

public class CaculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() throws Exception {
        int result = splitString(null);
        assertThat(result).isEqualTo(0);

        result = splitString("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = splitString("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = splitString("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = splitString("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = splitString("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> splitString("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자열을 분리")
    int splitString(String text) throws Exception {

        if(text == null || text.isEmpty()) {
            return emptyStringOrNull(text);
        }

        if(text.contains("-")) {
            return stringWithNegative(text);
        }

        if(text.length() == 1) {
            return oneString(text);
        }

        if(text.contains(",") && text.contains(":")) {
            return stringWithCommaAndColon(text);
        }

        if(text.contains(",")) {
            return stringWithComma(text);
        }

        return stringWithVariousSeperator(text);
    }

    @DisplayName("문자열이 빈문자열 또는 null")
    int emptyStringOrNull(String text) {
        return 0;
    }

    @DisplayName("문자열이 숫자 하나")
    int oneString(String text) {
        return Integer.parseInt(text);
    }

    @DisplayName("콤마를 통한 문자열 분리")
    int stringWithComma(String text) {
        int sum = 0;
        String[] tmp = text.split(",");

        for(String s : tmp) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    @DisplayName("콤마와 콜론 구분자를 통한 문자열 분리")
    int stringWithCommaAndColon(String text) {
        int sum = 0;
        String[] tmp = text.split(",|:");

        for(String s : tmp) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    @DisplayName("커스텀 구분자를 통한 문자열 분리")
    int stringWithVariousSeperator(String text) { // 예시 : //;\n1;2;3
        int sum = 0;
        String[] tmp = null;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1); // 예시 케이스 기준 m.group(1)은 ;
            tmp = m.group(2).split(customDelimiter); // 예시 케이스 기준  m.group(2)는 1;2;3
        }

        for(String s : tmp) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    @DisplayName("문자열에 음수가 포함")
    int stringWithNegative(String text) throws Exception {
        throw new RuntimeException();
    }
}
