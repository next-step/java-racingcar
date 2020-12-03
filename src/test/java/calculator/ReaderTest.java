package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("판독기(Reader) 테스트")
public class ReaderTest {

    @DisplayName("판독기 생성 시 생성자를 통해 구분자를 주입하여 생성할 수 있다.")
    @Test
    void create() {
        // given
        String separator = " ";
        Reader reader = new Reader(separator);

        // when / then
        assertThat(reader).isNotNull();
    }

    @DisplayName("여러 구분자의 문자열을 계산식으로 만들 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "a,1a+a3",
            "and,1and+and2and-and4and/and2and*and10"})
    void read(String separator, String value) {
        // given
        Reader reader = new Reader(separator);

        // when
        Expression expression = reader.read(value);

        // then
        assertThat(expression).isNotNull();
    }
}
