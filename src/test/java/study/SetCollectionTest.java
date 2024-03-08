package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetCollectionTest {
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
    @DisplayName("size() 메소드로 Set의 크기 확인")
    void getSizeOfSet__success() {
        // when
        int setSize = numbers.size();

        // then
        assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("ParameterizedTest로 중복 코드를 제거하여 contains() 메소드로 값 존재 확인")
    void containNumbers__shouldHaveOneToThree(int number) {
        // when, then
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("CsvSource로 입력 값에 따라 결과 값이 다른 테스트 결과 확인")
    void containsNumbers__shouldReturnFalseFromFour(int input, boolean expected) {
        // when, then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
