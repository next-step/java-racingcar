import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConverterTest {
    private Converter converter;

    @BeforeEach
    void setUp() {
        converter = new Converter();
    }

    @Test
    @DisplayName("[2] 분리된 문자열을 Integer 리스트로 변환")
    public void convertTest1() {
        List<String> given = List.of("1", "2", "3");
        List<Integer> actual = converter.convert(given);
        assertThat(actual).contains(1);
        assertThat(actual).contains(2);
        assertThat(actual).contains(3);
    }

    @Test
    @DisplayName("[2] 숫자가 아닌 값을 전달하는 경우 RuntimeException 예외를 throw")
    public void convertTest2() {
        List<String> given = List.of("1", "abc", "3");
        assertThatThrownBy(() -> {
            List<Integer> unknown = converter.convert(given);
        }).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("[2] 음수를 전달하는 경우 RuntimeException 예외를 throw")
    public void convertTest3() {
        List<String> given = List.of("1", "-2", "3");
        assertThatThrownBy(() -> {
            List<Integer> unknown = converter.convert(given);
        }).isExactlyInstanceOf(RuntimeException.class);
    }
}
