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
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set : numbers의 크기를 확인")
    public void size(){
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("Set : numbers가 비어있는지 확인")
    public void isEmpty(){
        assertThat(numbers.isEmpty()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("파라미터의 값이 Set에 포함되어있는지 확인")
    void containsNumber(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    // CsvSource의 경우 delimiter값은 [char]
    @ParameterizedTest
    @CsvSource(value = {"1:true","3:true","4:false"}, delimiter = ':')
    @DisplayName("파라미터의 값이 Set에 포함되어있는지 확인 (csv사용)")
    void containsNumberUseCsvSource(int number, boolean result){
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
