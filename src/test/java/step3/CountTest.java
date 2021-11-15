package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CountTest {

    private Count count;

    @BeforeEach
    public void createCount() {
    }
    
    @ParameterizedTest
    @CsvSource(value = {"2,2", "5,5", "7,7", "8,8", "1,1"})
    @DisplayName("Count 객체 생성시 인자로 숫자를 받는다.")
    public void newCount(int input, int expected) {
        count = new Count(input);

        Assertions.assertThat(count).isEqualTo(new Count(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -10})
    @DisplayName("Count 객체 생성시 0이하 값을 인자로 받을시 예외를 던진다")
    public void CountThrow(int input) {
        assertThatThrownBy(() -> {
            new Count(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}