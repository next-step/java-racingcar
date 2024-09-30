package stringadder.delimiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringadder.exception.StringAddIllegalArgumentException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterNumberParserFactoryTest {
    private final DelimiterNumberParserFactory delimiterNumberParserFactory = new DelimiterNumberParserFactory();

    @DisplayName("입력값에 커스텀 구분자가 있으면 customDelimiterNumberParser을 반환할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {";", "!", "@", "#", "%"})
    void getNumberParserReturnCustomDelimiterNumberParser(String customDelimiterNumber) {
        // given
        String text = "//" + customDelimiterNumber + "\n1" + customDelimiterNumber + "2" + customDelimiterNumber + "3";

        // when
        NumberParser numberParser = delimiterNumberParserFactory.getNumberParser(text);

        // then
        assertThat(numberParser).isInstanceOf(CustomDelimiterNumberParser.class);
    }

    @DisplayName("입력값에 기본 구분자가 있으면 defaultDelimiterNumberParser을 반환할 수 있다.")
    @Test
    void getNumberParserReturnDefaultDelimiterNumberParser() {
        // given
        String text = "1,2:3";

        // when
        NumberParser numberParser = delimiterNumberParserFactory.getNumberParser(text);

        // then
        assertThat(numberParser).isInstanceOf(DefaultDelimiterNumberParser.class);
    }

    @DisplayName("입력값에 기본 구분자와 커스텀 구분자 패턴이 없으면 에러를 반환한다.")
    @Test
    void getNumberParserReturnException() {
        // given
        String text = "1!2!3";

        //when & then
        assertThatThrownBy(() -> delimiterNumberParserFactory.getNumberParser(text))
                .isInstanceOf(StringAddIllegalArgumentException.class);
    }
}