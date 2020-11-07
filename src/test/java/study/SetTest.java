package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("Set의 크기를 확인")
    void size(){
        assertThat(numbers.size()).isEqualTo(3);
    }
    @Test
    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
    @Test
    @DisplayName("assertAll 사용 ,assertAll()은 여러 검증을 하나로 묶어서 테스트 할 수 있게 해준다.")
    void assertAllTest() {
        assertAll(
                //A Case
                () -> assertThat(numbers.contains(1)).isTrue(),

                //B Case
                () -> assertThat(numbers.contains(2)).isTrue(),

                //C Case
                () -> assertThat(numbers.contains(3)).isTrue()
                );
    }

    @DisplayName("ParameterizedTest를 활용해 중복 코드를 제거")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void parameterizedTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }


    @DisplayName("ParameterizedTest를 활용해 예측 값도 Parameterized")
    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenercontainsateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

}
