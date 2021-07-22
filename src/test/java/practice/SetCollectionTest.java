package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @DisplayName("size()는 set의 크기를 반환해야한다.")
    @Test
    void TEST_size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("set에 1,2,3 값이 포함되어야한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void TEST_contains(int number){
        assertThat(numbers.contains(number)).isTrue();
    }
}
