package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현

    @Test
    void size() {
        //setUp한번호출
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void contains() {
        //setUp 너무많이 호출...
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3}) // six numbers
    void contains(int number) {
        //setUp 너무많이 호출...
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(String input, String expected) {
        boolean isContain = numbers.contains(Integer.parseInt(input));
        assertThat(isContain).isEqualTo(Boolean.parseBoolean(expected));
    }
}