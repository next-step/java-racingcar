package studytest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @DisplayName("Set 자료구조의 size 메서드는 보유한 요소의 갯수를 반환한다.")
    public void 테스트_자료구조_Set_size() {
        assertThat(numbers.size()).isEqualTo(3);
        numbers.add(10);
        assertThat(numbers.size()).isEqualTo(4);
    }

    @DisplayName("Set 자료구조의 contains 메서드는 전달된 인자를 보유한 요소의 포함되어 있는지 여부를 반환한다. ")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 테스트_자료구조_Set_contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("Set 자료구조의 contains 메서드는 전달된 인자를 보유한 요소의 포함되어 있는지 여부를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void 테스트_자료구조_Set_contains(int value, boolean result) {
        assertThat(numbers.contains(value)).isEqualTo(result);
    }
}
