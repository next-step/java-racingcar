package step4.dto.count;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 10, 100})
    @DisplayName("1 이상의 값을 입력하면 객체가 정상적으로 생성된다")
    public void createTest(int input) {
        Count count = new Count(input);

        assertThat(count.getCount()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -7})
    @DisplayName("0 미만의 값을 인자로 받으면 예외를 던진다")
    public void exceptionTest(int input) {
        assertThatThrownBy(() -> {
            new Count(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}