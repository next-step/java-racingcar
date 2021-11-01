import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
    void numbers_의_크기는_0보다_크다() {
        //given
        //when
        int numbersSize = numbers.size();
        //then
        assertThat(numbersSize).isGreaterThan(0);
    }

    @Test
    void numbers_의_크기는_3이다() {
        //given
        //when
        int numbersSize = numbers.size();
        //then
        assertThat(numbersSize).isEqualTo(3);
    }

    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void numbers_에_정수_1_2_3이_존재한다(int number) {
        //given
        //when
        //then
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void numbers_에_정수_4_5_6이_존재하지_않는다(int number) {
        //given
        //when
        //then
        assertThat(numbers.contains(number)).isFalse();
    }

}
