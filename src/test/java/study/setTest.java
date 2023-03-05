package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class setTest {
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
    @Test
    void setSize(){
        final int actual = numbers.size();
        assertThat(actual).isEqualTo(3);
    }

    @ValueSource(ints={1,2,3,4})
    @ParameterizedTest
    void contains(final int number) {
        assertThat(numbers.contains(number)).isTrue();
    }
}
