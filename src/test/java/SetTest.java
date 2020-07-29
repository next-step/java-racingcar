import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:53 오후
 */
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

    // Test Case 구현
    @Order(1)
    @Test
    @DisplayName("SizeTest")
    public void size() {
        //assertThat(numbers.size()).isEqualTo(3);

        assertThat(numbers).hasSize(3);
        assertThat(numbers.isEmpty()).isEqualTo(false);
        assertThat(numbers.isEmpty()).isFalse();
    }

    @Order(2)
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest")
    public void contains(int number) {
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();

        assertThat(numbers.contains(number)).isTrue();
    }

    @Order(3)
    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("CsvSourceTest")
    public void csvContains(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

}