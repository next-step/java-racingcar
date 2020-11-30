import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
