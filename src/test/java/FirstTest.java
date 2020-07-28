import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstTest {

    @Test
    @DisplayName("1,2를 , 로 split하면 1과 2인 배열이 생성되는지 확인")
    void firstSplitTest() {
        String input = "1,2";
        String[] split = input.split(",");

        String[] expected = {"1", "2"};
        assertThat(split).containsExactly(expected);
    }


}
