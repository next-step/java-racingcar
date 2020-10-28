package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("HashSet 의 크기 테스트")
    public void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("중복 코드를 제거한 HashSet 이 갖고 있는 값 테스트")
    @ValueSource(ints = {1, 2, 3})
    public void containsTest(final int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @DisplayName("CsvSource를 이용한 입력 값에 따른 결과 값 테스트")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    public void size1Test(final int number, final String bool) {
        assertEquals(Boolean.parseBoolean(bool), numbers.contains(number));
    }
}
