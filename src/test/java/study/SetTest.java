package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("Set 의 size 는 set 의 크기를 반환한다.")
    void size01(){
        int sut = numbers.size();

        assertThat(sut).isEqualTo(3);
    }

    @ParameterizedTest(name = "Set 의 contains 는 값의 존재여부를 반환한다. ({0} 은 포함된다.)")
    @ValueSource(strings = {"1", "2", "3"})
    void contain01(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "Set 의 contains 는 값의 존재여부를 반환한다. ({0} 은 {1})")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contain02(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
