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
    private Set numbers;

    @BeforeEach
    public void dummy() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메서드 테스트를 성공 한다.")
    @Test
    void size() {
        final int size = 3;
        assertThat(numbers).isNotNull();
        assertThat(numbers).hasSize(size);
    }


    @DisplayName("Set의 contains 메서드 테스트를 성공 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_ExpectedSuccess(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set의 contains 메서드 테스트를 성공 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false"})
    void contains_ExpectedFail(int input, boolean expect) {
        assertThat(numbers.contains(input)).isEqualTo(expect);
    }
}
