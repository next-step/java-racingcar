package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * calculator 패키지 안 파일들은 줌 강의를 보고 학습용으로 작성한 내용입니다.
 */
public class StringTest {
    /**
     * api가 내가 생각하는대로 잘 동작하는지 테스트
     *
     * 학습테스트에 대한 장점.
     */
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).hasSize(2);
        assertThat(values).containsExactly("1", "2");

        values = "1".split(",");
        assertThat(values).hasSize(1);
        assertThat(values).containsExactly("1");
    }
}
