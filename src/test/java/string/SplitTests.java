package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.beans.Transient;

/**
 * 요구사항 1.
 */
public class SplitTests {
    @Test
    @DisplayName("\"1,2\"를 쉼표로 분리하면 \"1\"과 \"2\"를 포함하는 배열이 생성된다")
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1,\"을 쉼표로 분리하면 \"1\"만 포함하는 배열이 생성된다")
    void split_one() {
        assertThat("1".split(",")).containsExactly("1");
    }
}
