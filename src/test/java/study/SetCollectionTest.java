package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    @Test
    void checkSizeOfSet() {
        // given
        final int expected = 3;

        // when
        final int actual = this.numbers.size();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "- numbers Set은 {0} 를 포함한다")
    @ValueSource(ints = {1, 2, 3})
    void checkIfSetContains(final int input) {
        // given & when
        final boolean actual = this.numbers.contains(input);

        // then
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "- numbers Set의 {0} 포함 여부는 {1} 이다")
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void checkIfSetContainsWithExpected(final int input, final boolean expected) {
        // given & when
        final boolean actual = this.numbers.contains(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
