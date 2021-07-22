package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("Set의 size() 메소드를 사용해 3를 반환")
    @Test
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest(name = "Set의 contains() 메소드를 사용하여 {0}은 True가 반환되어야한다")
    void containsTest(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @ParameterizedTest(name = "Set의 contains() 메소드를 사용하여 {0}의 {1}가 반환되어야한다")
    void containsTest(int value, boolean bool) {
        assertThat(numbers.contains(value)).isEqualTo(bool);
    }

}
