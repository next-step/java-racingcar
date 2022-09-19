package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("Set 클래스 size 메소드 학습 테스트")
    void size() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set 클래스 contains 메소드 학습 테스트")
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        boolean result = numbers.contains(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set 클래스 contains 메소드 true, false 결과를 모두 포함한 학습 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(String input, String expected) {
        boolean result = numbers.contains(Integer.parseInt(input));
        assertThat(result).isEqualTo(Boolean.parseBoolean(expected));
    }
}
