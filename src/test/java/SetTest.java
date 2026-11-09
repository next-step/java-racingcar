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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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



    @Test
    @DisplayName("Set의 크기의 크기를 성공적으로 반환한다")
    void set의_크기를_성공적으로_반환한다() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("set에 특정 원소가 포함되면 성공을 반환한다")
    void set에_특정_원소가_포함되면_성공을_반환한다(int input) {

        assertThat(numbers.contains(input)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false","5:false"}, delimiter = ':')
    @DisplayName("set 에 특정 원소 유무를 판단한다")
    void set에_특정_원소_유무를_판단한다(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
