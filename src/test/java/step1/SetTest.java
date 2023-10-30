package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("Set 컬렉션이 중복을 허용하는지 확인하는 테스트")
    void checkSetSize() {
        // given
        // when
        // then
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = "Set 컬렉션에 {0} 값이 있는지 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void checkValueExist(int target) {
        // given
        // when
        // then
        assertThat(numbers.contains(target)).isTrue();
    }

    @ParameterizedTest(name = "Set 컬렉션에 {0} 값의 존재 유무는 {1} 인지 확인하는 테스트")
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void checkValueWithNotExist(int target, boolean result) {
        // given
        // when
        // then
        assertThat(numbers.contains(target)).isEqualTo(result);
    }
}
