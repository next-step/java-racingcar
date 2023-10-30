import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        //given
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Nested
    class 요구_사항_1 {
        @Test
        void set_size_확인() {
            //when
            int size = numbers.size();

            //then
            assertThat(size).isEqualTo(3);
        }
    }

    @Nested
    class 요구_사항_2 {
        @DisplayName("ParameterizedTest 를 활용해 contains 가 true 인 경우만 확인")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        void contains_ShouldReturnTrueForContainedInt(int input) {
            //when, then
            assertThat(numbers.contains(input)).isTrue();
        }
    }

    @Nested
    class 요구_사항_3 {
        @DisplayName("ParameterizedTest 를 활용해 contains 가 true, false 인 경우 확인")
        @ParameterizedTest
        @CsvSource(value = {"1,true", "2,true", "4,false", "3,true", "6,false"})
        void contains_ShouldReturnTrueOrFalseForInput(int input, boolean expected) {
            //when, then
            assertThat(numbers.contains(input)).isEqualTo(expected);
        }
    }
}