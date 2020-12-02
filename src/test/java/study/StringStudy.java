package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringStudy {

    @DisplayName("콤마 split 테스트")
    @Test
    public void contains() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @DisplayName("콤마 split 특정값만 포함하는지 테스트")
    @Test
    public void containsExactly() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("substring 학습 테스트")
    @Test
    public void substring() {
        String str = "(1,2)";
        String actual = str.substring(1, str.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

}
