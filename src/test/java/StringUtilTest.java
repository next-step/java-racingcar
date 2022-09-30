import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    @DisplayName(" \"1,2\" 를 \",\" 기준으로 split() 메소드를 이용하여 분리 되는지 확인하는 테스트")
    public void stringSplitTest() {

        String testCase1 = "1,2";
        String testCase2 = "1";

        String[] test1Arr = testCase1.split(",");
        String[] test2Arr = testCase2.split(",");

        assertThat(test1Arr).contains("1", "2");
        assertThat(test1Arr).containsExactly("1", "2");
        assertThat(test2Arr).contains("1");
    }


    @Test
    @DisplayName(" \"(1,2)\" 값이 주어졌을 때 substring 메소드를 통해 \"()\" 를 제거하고 \"1,2\" 를 반환하는 테스트 ")
    public void stringSubStringTest() {

        String testCase1 = "(1,2)";

        String test1 = testCase1.substring(1, 4);

        assertThat(test1).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 이용해 문자열 인덱스를 벗어난 값을 갖고오는 경우 Exception 이 발생하는 테스트")
    public void stringCharAtTest() {

        String testCase = "abc";

        assertThatThrownBy(() -> {
            testCase.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 4");
    }
}
