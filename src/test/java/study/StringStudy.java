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
}
