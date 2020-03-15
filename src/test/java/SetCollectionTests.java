import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTests {
    private Set numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항 1. size() 테스트")
    @Test
    public void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항 2. contains() 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void setContainsTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("요구사항 3. 예상 결과를 포함한 contains() 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    public void setContainsTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
