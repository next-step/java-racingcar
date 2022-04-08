package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("중복된 원소를 포함한 집합")
class SetTest {

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
    @DisplayName("중복된 원소는 사이즈에서 제외")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = "[{index}] {0} 값은 포함인 것이 {1}")
    @DisplayName("[1,1,2,3] 집합에 포함 여부")
    @CsvSource({"0,false", "1,true", "2,true", "3,true", "4,false"})
    void contains(int target, boolean expected) {
        //when
        boolean contains = numbers.contains(target);
        //then
        assertThat(contains).isEqualTo(expected);
    }
}
