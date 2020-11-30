import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("split 메서드를 통해 주어진 문자열을 구분자로 나눌 수 있는지 확인하는 학습 테스트")
    @Test
    void splitOneAndTwoTest() {
        String target = "1,2";
        String splitter = ",";
        String[] splatTarget = target.split(splitter);

        String expectedResult1 = "1";
        String expectedResult2 = "2";

        assertThat(splatTarget[0]).isEqualTo(expectedResult1);
        assertThat(splatTarget[1]).isEqualTo(expectedResult2);
    }

    @DisplayName("split 메서드를 통해 구분자가 없는 문자열을 나눌 경우 주어진 문자열을 그대로 반환하는지 확인하는 학습 테스트")
    @Test
    void splitWithoutSplitStringTest() {
        String target = "1";
        String splitter = ",";

        String splatFirstResult = target.split(splitter)[0];

        assertThat(splatFirstResult).isEqualTo(target);
    }

    @DisplayName("substring 메서드를 통해 주어진 문자열 중 원하는 위치의 문자열을 제거할 수 있는지 확인하는 학습 테스트")
    @Test
    void substringTest() {
        String target = "(1,2)";
        String expectedResult = "1,2";

        int startIndex = 1;
        int lastIndex = target.length() - 1;

        assertThat(target.substring(startIndex, lastIndex)).isEqualTo(expectedResult);
    }

    @DisplayName("charAt 메서드를 통해 주어진 문자열의 특정 위치에 있는 문자열을 가져올 수 있는지 확인하는 학습 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAtTest(int index, char expectedResult) {
        String target = "abc";

        assertThat(target.charAt(index)).isEqualTo(expectedResult);
    }

    @DisplayName("charAt 메서드를 통해 주어진 문자열의 크기를 벗어난 index의 문자열을 요구하는 경우 에러가 발생하는지 확인하는 학습 테스트")
    @Test
    void charAtWithOutOfRangeIndexTest() {
        String target = "abc";
        int outOfRangeIndex = target.length();

        assertThatThrownBy(() -> target.charAt(outOfRangeIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
