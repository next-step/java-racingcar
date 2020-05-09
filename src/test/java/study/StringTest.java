package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * String 클래스에 대한 학습 테스트
 *
 * 요구사항 1.
 *  - "1,2"을 ","로 split 했을 때, 1과 2로 잘 분리되는지 확인
 */
public class StringTest {

    @Test
    void split() {
        // Given
        String test = "1,2";

        // When
        String[] result = test.split(",");

        // Then
        assertThat(result).containsExactly("1","2");
    }
}
