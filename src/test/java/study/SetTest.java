package study;

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

@DisplayName("Set Collection에 대한 학습 테스트")
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
    @DisplayName("Set size 확인")
    public void setTest01() throws Exception {
        assertThat(numbers.size()).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set 값 존재여부 확인")
    public void setTest02(int inputNumber) throws Exception {
        assertThat(numbers.contains(inputNumber)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false","1:true","2:true","3:true","4:false"}, delimiter = ':')
    @DisplayName("Set 값 존재 확인")
    public void setTest03(int inputNumber, boolean isFree) throws Exception {
        assertThat(numbers.contains(inputNumber)).isEqualTo(isFree);
    }
}
