package learningstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("[요구사항1] numbers 의 사이즈 구하기")
    @Test
    public void size() {
        // given

        // when
        int size = numbers.size();

        // then
        assertThat(size).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("[요구사항2] numbers 에 포함된 값들 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void contains(Integer value) {
        // given

        // when

        // then
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("[요구사항3] numbers 에 포함된 값들 확인 - false 도 같이")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void contains2(Integer value, Boolean expected) {
        // given

        // when

        // then
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
