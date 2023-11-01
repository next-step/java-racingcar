package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습")
    void checkSetSize() {
        assertThat(numbers.size()).isNotZero();
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인한다.")
    void setContains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인한다. 또한 중복 코드를 제거해본다.")
    @ValueSource(ints = {1, 2, 3})
    void setContainsNusingParameterized(int param) {
        assertThat(numbers.contains(param)).isTrue();
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트를 구현한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void inputAndExpectedTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
