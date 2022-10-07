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

@DisplayName("Set Collection에 대한 학습 테스트")
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

    @DisplayName("요구사항 1")
    @Test
    void setSize() {
        Integer size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("요구사항 2")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containTest(int params) {
        assertThat(numbers.contains(params)).isTrue();
    }


    @DisplayName("요구사항 3")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void differentOutputTest(int input,Boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
