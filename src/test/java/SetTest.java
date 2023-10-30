import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection에 대한 학습 테스트")
class SetTest {

    private  Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set은 데이터가 중복될 수 없다.")
    void size_크기확인() {
        // when then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("Set은 contains로 데이터 유무를 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void contains_데이터확인(int number, boolean result) {
        // when then
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
