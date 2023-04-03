package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    @Test
    void requirements_1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드를 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void requirements_2(int i) {
        assertThat(numbers.contains(i)).isTrue();
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void requirements_3(int i, boolean expected) {
        assertThat(numbers.contains(i)).isEqualTo(expected);
    }

}
