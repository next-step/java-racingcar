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
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트 구현")
    @Test
    void set_메소드_학습테스트() {
        int actual = numbers.size();

        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트 구현")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains_메소드_학습테스트(int actual) {
        assertThat(numbers.contains(actual)).isTrue();
    }

    @DisplayName("contains() 메소드를 활용해 1, 2, 3 값은 contains 메소드 실행 결과가 true, 4, 5 값을 넣으면 false 가 반환되는 학습 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 숫자_1_2_3_4_5_를_포함하는지_테스트(int actual, boolean expected) {
        assertThat(numbers.contains(actual)).isEqualTo(expected);
    }

}