package learningtest;

import java.util.Arrays;
import javax.swing.Spring;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * String 클래스에 대한 학습 테스트
 */
public class JavaUtilStringClassLearningTest {

    // 요구사항 1
    // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

    @Nested
    @DisplayName("String.split() 메서드 학습 테스트")
    class Split {

        @Test
        @DisplayName("문자열 '1,2' 분리")
        void splitOneCommaTwoString() {
            String testString = "1,2";
            String[] actual = testString.split(",");

            Assertions.assertThat(actual).hasSize(2);
            Assertions.assertThat(actual).containsExactly("1", "2"); // if the order does matter

        }

        @Test
        @DisplayName("단일 문자열 분리")
        void splitSingleString() {
            String testString = "1";
            String[] actual = testString.split(",");

            Assertions.assertThat(actual).hasSize(1);
            Assertions.assertThat(actual).containsOnly("1");
        }

    }

}
