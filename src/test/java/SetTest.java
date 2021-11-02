import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Set Collection 학습 테스트")
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
    @DisplayName("size 가 정상적으로 리턴")
    public void sizeIsNormalValue() {
        int numbersSize = numbers.size();
        Assertions.assertThat(numbersSize).isEqualTo(3);
    }

    @ParameterizedTest(name="Set 에 {index} 데이터가 존재하면 정상 수행")
    @ValueSource(ints={1, 2, 3})
    public void whetherTheValueExists(int increasingNumber) {
        assertTrue(numbers.contains(increasingNumber));
    }
}
