import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("set 의 크기를 확인하는 학습 테스트")
    @Test
    public void sizeOfSetTest() {
        int sizeOfSet = numbers.size();

        assertThat(sizeOfSet).isEqualTo(3);
    }

    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void containsTest(int value) {
        assertThat(numbers).contains(value);
    }

    @DisplayName("1, 2, 3 외 존재하지 않는 4, 5 도 인자로 주어 결과 값이 다른 Case 에 대한 학습테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void containsOtherTest(int input, boolean expect) {
        assertThat(numbers.contains(input)).isEqualTo(expect);
    }

}
