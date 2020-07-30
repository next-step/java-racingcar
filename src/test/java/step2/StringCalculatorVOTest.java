package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorVOTest {

    private StringCalculatorVO stringCalculatorVO = new StringCalculatorVO();

    @DisplayName("공백 기준으로 String 나누기")
    @Test
    void splitStringByWhiteSpace() {
        String given = "1 2 3 4";

        assertThat(stringCalculatorVO.splitStringByWhiteSpace(given)).containsExactly("1","2","3","4");
    }

    @DisplayName("String 배열에서 숫자만 뽑아서 새로운 배열로 반환")
    @Test
    void filterNumberStringFromStringArray() {
        String[] given = new String[]{"1","+","3","*","4"};

        assertThat(stringCalculatorVO.filterNumberStringFromStringArray(given)).containsExactly("1","3","4");
    }

    @DisplayName("String 배열에서 사칙연산 기호만 뽑아서 새로운 배열로 반환")
    @Test
    void filterOperatorStringFromStringArray() {
        String[] given = new String[]{"1","/","3","*","4","+","5","-","6"};

        assertThat(stringCalculatorVO.filterOperatorStringFromStringArray(given)).containsExactly("/","*","+","-");
    }

    @DisplayName("String을 Integer로 변환")
    @Test
    void parseStringToInteger() {
        String given = "99";

        assertThat(stringCalculatorVO.parseStringToInteger(given)).isEqualTo(99);
    }

    @DisplayName("String 배열을 Integer 배열로 변환")
    @Test
    void transformStringArrayToIntegerArray() {
        String[] given = new String[]{"1","2","3","4"};

        assertThat(stringCalculatorVO.transformStringArrayToIntegerArray(given)).containsExactly(1,2,3,4);
    }

}