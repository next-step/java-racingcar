package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("set의 크기를 확인한다")
    void check_size(){
        final int setSize = 3;
        assertThat(setSize).isEqualTo(setSize);
    }

    @ParameterizedTest
    @DisplayName("set의 원소를 확인한다")
    @ValueSource(ints = {1,2,3,4,5})
    void check_elements(int number){
        boolean condition = checkIfContains(number);
        assertThat(numbers.contains(number)).isEqualTo(condition);
    }

    private boolean checkIfContains(int number) {
        return number < 4;
    }
}
