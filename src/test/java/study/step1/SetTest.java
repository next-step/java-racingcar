package study.step1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @Order(1)
    @DisplayName("1) size() 테스트")
    @Test
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Order(2)
    @ParameterizedTest(name = "2) contains() 다중 입력 테스트: {arguments}")
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int n) {
        assertThat(numbers.contains(n)).isTrue();
    }

    @Order(3)
    @ParameterizedTest(name = "3) contains() 다중 조건 테스트: {arguments}")
    @CsvSource(value = {
            "1:true",
            "2:true",
            "3:true",
            "4:false",
            "5:false"
    }, delimiter = ':')
    void containsTest2(int n, boolean result) {
        assertThat(numbers.contains(n)).isEqualTo(result);
    }
}
