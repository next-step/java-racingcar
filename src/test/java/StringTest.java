import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @DisplayName("split 메서드를 통해 \"1,2\"를 \"1\", \"2\"로 나눌 수 있는지 확인하는 학습 테스트")
    @Test
    void splitOneAndTwoTest() {
        String target = "1,2";
        String[] splatTarget = target.split(",");

        assertThat(splatTarget[0]).isEqualTo("1");
        assertThat(splatTarget[1]).isEqualTo("2");
    }
}
