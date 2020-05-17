package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Step1 - String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("요구사항 1 - containsExactly의 사용")
    public void 요구사항_1() {
        String testStr = "1,2";
        String[] splitArr = testStr.split(",");

        assertThat(splitArr).containsExactly("1","2");
    }

    @DisplayName("요구사항 2 - isEqualsTo의 사용")
    @Test
    public void 요구사항_2() {
        String testStr = "(1,2)";
        testStr = testStr.substring(1, testStr.length()-1);

        assertThat(testStr).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3 - Exeption 처리에 대한 테스트")
    @Test
    public void 요구사항_3() {
        int idxPosition = 4;
        String testStr = "abc";
        String exceptionMsg = "String index out of range: ";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    testStr.charAt(idxPosition);
                }).withMessage(exceptionMsg + idxPosition);
    }
}
