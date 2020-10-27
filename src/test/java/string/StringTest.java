package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("String 클래스 학습테스트 요구사항 1")
    void stringSplitTest() {
        String value1 = "1,2";

        String[] split1 = value1.split(",");

        assertThat(split1).contains("1", "2");
        assertThat(split1).containsExactly("1", "2");

        String value2 = "1,";

        String[] split2 = value2.split(",");

        assertThat(split2).contains("1");
        assertThat(split2).containsExactly("1");
    }
}
