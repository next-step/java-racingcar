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

/**
 * Created by owen.ny on 2021/11/04.
 */
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
    @DisplayName("Set size 테스트")
    public void 요구사항1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set contains 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 요구사항2(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("Set contains 예외 포함 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void 요구사항3(int value, boolean result) {
        assertThat(numbers.contains(value)).isEqualTo(result);
    }
}
