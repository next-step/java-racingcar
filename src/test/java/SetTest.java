import org.assertj.core.api.Assertions;
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
    void beforeEach() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    @Test
    @DisplayName("size() 를 사용하여 Set 의 크기를 구하다.")
    void sizeTest() {
        // Given
        // When
        int size = numbers.size();

        // Then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("@ParameterizedTest 를 사용하여 contains 중복을 제거하다.")
    void containsTest1(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("@CsvSource 를 사용하여 false 케이스도 테스트해보다.")
    void containsTest2(int number, Boolean isContains) {
        assertThat(numbers.contains(number)).isEqualTo(isContains);
    }
}
