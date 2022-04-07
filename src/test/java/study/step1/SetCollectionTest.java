package study.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection 에 대한 학습 테스트")
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
    
    @DisplayName("size() 를 이용하여 Set 의 크기 확인")
    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("contains 함수에 대한 학습테스트 - 성공케이스")
    @ParameterizedTest
    @ValueSource(ints = {1, 2 ,3})
    void containsSuccessCase(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("contains 함수에 대한 학습테스트 - 실패케이스")
    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void parameterizedValueTest(int input) {
        assertThat(numbers.contains(input)).isFalse();
    }

    @DisplayName("CsvSource 에 대한 학습 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void parameterizedCsvTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
