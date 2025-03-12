package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    @DisplayName("요구사항 1: size, set 의 크기 확인")
    public void size() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2: contains, set 에 원하는 원소가 저장되어 있는지 확인 (미포함 원소가 들어가면 테스트 실패)")
    public void contains1(int source) {
        assertThat(numbers.contains(source))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항 3: contains, set 에 원하는 원소가 저장되어 있는지 확인 (미포함 원소도 확인 가능)")
    public void contains2(int source, boolean result) {
        assertThat(numbers.contains(source))
                .isEqualTo(result);
    }
}
