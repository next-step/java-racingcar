package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection에 대한 학습 테스트")
class SetTest {
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
    @DisplayName("Set의 size() 메소드는 Set의 크기를 반환합니다.")
    void size() {
        assertThat(numbers.size()).isSameAs(3);
    }

    @ParameterizedTest(name = "Set의 contains() 메소드는 포함여부를 반환합니다.({0}포함? {1})")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
