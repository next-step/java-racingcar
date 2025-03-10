import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
    void test1() {
        assertEquals(3, numbers.size());
    }

    @ParameterizedTest(name = "Set의 contains() 메소드를 활용해 다음 숫자가 존재하는지를 확인: {0}")
    @ValueSource(strings = {"1", "2", "3"})
    void test2(int num) {
        assertTrue(numbers.contains(num));
    }

    @ParameterizedTest(name = "입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현 - 입력 값: {0}, 결과 값: {1}")
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false",
    })
    void test3(int num, boolean expected) {
        assertEquals(expected, numbers.contains(num));
    }
}
