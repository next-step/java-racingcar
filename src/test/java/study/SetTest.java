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

public class SetTest {

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
    @DisplayName("[1. Set 크기 확인]")
    public void numbersSize() {
        // given
        int expected = 3;

        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[2. Set 요소 확인] : {arguments}")
    @ValueSource(ints = {1, 2, 3})
    public void contains1(int number) {
        // given

        // when
        boolean hasNumber = numbers.contains(number);

        // then
        assertThat(hasNumber).isTrue();
    }

    @ParameterizedTest(name = "[3, Set 요소 확인 (응용)] : {arguments}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void contains2(int number, boolean expected) {
        // given

        // when
        boolean hasNumber = numbers.contains(number);

        // then
        assertThat(hasNumber).isEqualTo(expected);
    }
}
