package learningtest;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Set Collection 학습 테스트")
public class SetCollectionLearningTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Nested
    @DisplayName("size() 메서드 학습 테스트")
    class Size {

        @Test
        @DisplayName("Set 크기 확인 - Set size() 메서드 활용")
        void assertSetSizeThroughSetSizeMethod() {
            assertThat(numbers.size()).isEqualTo(3);
        }

        @Test
        @DisplayName("Set 크기 확인 - AssertJ hasSize() 메서드 활용")
        void assertSetSizeThroughAssertJHasSizeMethod() {
            assertThat(numbers).hasSize(3);
        }
    }


}
