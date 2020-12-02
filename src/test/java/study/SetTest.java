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

@DisplayName("Set Collection에 대한 학습 테스트")
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
    @DisplayName("[요구사항 1] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("[요구사항 2] Set의 contains() 메소드를 활용해 입력값이 존재하는지를 확인하는 테스트")
    @ParameterizedTest(name = "{0}의 값이 존재 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("[요구사항 3] Set의 contains 메소드를 활용해 입력값의 존재여부에 따라 반환 값 확인하는 테스트")
    @ParameterizedTest(name = "{0} 값이 실행결과 {1}를 반환 확인")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_ShouldReturnTrueOrFalseForExistElement(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
