package step1;

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
    @DisplayName("size 를 통해 Set 크기 리턴")
    void setSizeTest() {
        // given
        // when
        int size = numbers.size();
        // then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints ={1, 2, 3})
    @DisplayName("contains 를 통해 set value 존재 여부 리턴")
    void setContainsTest(Integer input) {
        // given
        // when
        boolean contains = numbers.contains(input);
        // then
        assertThat(contains).isTrue();
    }

    @ParameterizedTest
    @DisplayName("csvSource 를 이용해 set value 존재 확인")
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setContainsUsingCsvSourceTest(Integer input, boolean expected) {
        // given
        // when
        boolean actual = numbers.contains(input);
        // then
        assertThat(actual).isEqualTo(expected);
    }

}
