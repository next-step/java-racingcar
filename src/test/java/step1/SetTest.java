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

@DisplayName("Set Collection 에 대한 학습 테스트")
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("특정 Set 의 사이즈를 확인한다.")
    @Test
    void requirement1() {
        final int actual = numbers.size();

        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("특정 Set 에 1,2,3의 값이 존재하는지 확인한다.")
    @Test
    void requirement2_1() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("특정 Set은")
    @ParameterizedTest(name = "{arguments}을 포함한다.")
    @ValueSource(ints = {1, 2, 3})
    void requirement2_2(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name = "{0}을 포함여부 -> {1}")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void requirement3(int number, boolean is) {
        assertThat(numbers.contains(number)).isEqualTo(is);
    }
}
