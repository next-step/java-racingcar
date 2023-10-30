package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetCollectionTest {

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
    @DisplayName("Set에 숫자가 중복없이 저장되었는지 테스트")
    void setSizeTest() {
        // given

        // when

        // then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("set contains 테스트")
    @ValueSource(ints = {1, 2, 3})
    void setContainsTest(int number) {
        // given

        // when

        // then
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Csv를 활용하여 set contains 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void csvContainTest(int number, boolean expected) {
        // given

        // when

        // then
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
