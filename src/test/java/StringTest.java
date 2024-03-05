import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jeongheekim
 * @date 3/5/24
 */
public class StringTest {

    @Test
    @DisplayName("String 변수값을 ,로 split하면 해당 원소를 순서대로 포함한다.")
    void stringSplitElementOrderlyContainsTest() {
        String str = "1,2";
        String[] split = str.split(",");
        assertThat(split).containsExactly("1","2");

    }

    @Test
    @DisplayName("String 변수값을 ,로 split하면 해당 원소를 포함한다.")
    void stringSplitElementContainsTest() {
        String str = "1,";
        String[] split = str.split(",");
        assertThat(split).contains("1");

    }

    @Test
    @DisplayName("괄호가 있는 문자열은 괄호를 제거하여 해당 원소를 포함한다.")
    void bracketStringSplitElementContainsTest() {
        String str = "(1,2)";
        String[] split = str.replaceAll("[\\(\\)]","").split(",");
        assertThat(split).containsExactly("1","2");
    }
}
