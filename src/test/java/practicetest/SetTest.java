package practicetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;
import java.util.HashSet;

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

    @DisplayName("Set 클래스의 size 메소드 동작 테스트")
    @Test
    public void testSetSize()
    {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set 클래스의 contains 메소드 동작 테스트: 메소드 결과 값이 true인 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testSetContains(int num)
    {
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("Set 클래스의 contains 메소드 동작 테스트: 메소드 결과 값이 false인 경우도 포함")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter= ':')
    public void testSetContainsFalse(int input, boolean result)
    {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
