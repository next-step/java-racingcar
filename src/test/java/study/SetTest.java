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
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    /**
     * collection을 테스트 할때는 contains(), hasSize() 같은 메서드를 활용
     */
    @DisplayName("요구사항1 : size() 테스트 ")
    @Test
    void setSize() {
        assertThat(numbers).contains(1);
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("요구사항2 : contains() 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int no) {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("요구사항3 : contains() 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void contains2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}

