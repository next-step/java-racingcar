package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
    void size() {
        assertThat(numbers).hasSize(3);
    }

    // valueSource 에 사전 정의해둔 값을 하나씩 넣어서 테스트 해준다.
    // 테스트 구문은 똑같은데 값만 다를경우 유용하게 사용할 수 있다.
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int no) {
        assertThat(numbers.contains(no)).isTrue();
    }

    //input 에 따라 output 또한 변경될때 유용하게 사용할 수 있다.
    @ParameterizedTest
    @CsvSource(value = {"1:true", "4:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int no, boolean result) {
        assertThat(numbers.contains(no)).isEqualTo(result);
    }

}
