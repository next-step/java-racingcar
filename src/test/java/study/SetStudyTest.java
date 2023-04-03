package study;

<<<<<<< HEAD
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
=======
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
>>>>>>> 5511fe6 (test - size 테스트)
=======
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
>>>>>>> 831740c (test - contains 테스트)

import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
import static org.assertj.core.api.Assertions.assertThat;
=======
import static org.assertj.core.api.Assertions.*;
>>>>>>> 5511fe6 (test - size 테스트)

public class SetStudyTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    @DisplayName("Set Size 맞을 경우 테스트")
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4})
    @DisplayName("contains 테스트")
    void containsTest(int input) {
=======
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4})
    @DisplayName("contains 테스트")
    void containsTest(Integer input) {
>>>>>>> 831740c (test - contains 테스트)
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4})
    @DisplayName("contains 테스트")
<<<<<<< HEAD
    void setContainsTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "4:true", "5:false", "10:false"}, delimiter = ':')
    @DisplayName("csvSource 활용 테스트")
    void csvSourceTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

=======
>>>>>>> 5511fe6 (test - size 테스트)
=======
    void setContainsTest(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

>>>>>>> 831740c (test - contains 테스트)
}
