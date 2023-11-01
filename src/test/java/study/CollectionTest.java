package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionTest {
    private Set<Integer> numbers;

    @BeforeEach //테스트 메서드 실행 이전에 수행된다.
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


    @DisplayName("요구사항1")
    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("요구사항2")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void duple(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항3")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void csv(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
