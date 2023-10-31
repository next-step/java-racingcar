package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.lang.Integer.parseInt;
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

    // Test Case 구현
    @Test
    @DisplayName("Set의 Size 구하기")
    void 요구사항1(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요소 존재 여부 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3} )
    void 요구사항2(int input){
        assertThat(numbers.contains(input)).isTrue();
    }


    @DisplayName("입력값에 따라 결과가 다른 경우")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void 요구사항3(String input, String expected){
        assertThat(numbers.contains(parseInt(input)))
                .isEqualTo(Objects.equals(expected, "true"));
    }


}
