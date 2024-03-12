package learningtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Step1 - Set Collection에 대한 학습테스트")
public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인한다")
    void testSetSize() {
        assertThat(numbers).hasSize(3);
    }

    @Nested
    @DisplayName("contains() 테스트")
    class ContainsTest {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("ParameterizedTest를 활용해 중복 코드를 제거하여 테스트를 수행한다")
        void testRemoveDupMethod(int value) {
            assertThat(numbers).contains(value);
        }

        @ParameterizedTest
        @CsvSource(value = {"1:true, 2:true, 3:true, 4:false, 5:false"}, delimiter = ':')
        @DisplayName("Set에 포함유무에 따라 boolean값을 반환한다")
        void testVariousResults(int input, boolean expected) {
            assertEquals(expected, numbers.contains(input));
        }
    }
}
