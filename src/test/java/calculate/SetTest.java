package calculate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;
    //상수화 만들기
    private static final int NAME_LENGTH = 1;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void set사이즈_체크() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    boolean setTest(int num) {
        if (!numbers.contains(num)) {
            return false;
        }
        return true;
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void forList(int num) {
        assertThat(true).isEqualTo(numbers.contains(num));
    }


    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int input, boolean expected) {
        boolean actualValue = numbers.contains(input);
        assertEquals(expected, actualValue);

//        assertDoesNotThrow() > new;
//            throw new il

    }


}

