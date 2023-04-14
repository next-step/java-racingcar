package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {
    final String basicDelimiter = ":|,";

    @Test
    @DisplayName("커스텀구분자가 들어올 경우 커스텀 구분자를 구분자항목에 추가한 값을 반환한다")
    void 커스텀_구분자_등록() {
        final String customDelimiter = "%";
        final String text = "//" + customDelimiter + "\n1,2:3";

        final Delimiter delimiter = Delimiter.of(text);

        assertThat(delimiter)
                .extracting("custom")
                .isEqualTo(customDelimiter);
        assertThat(delimiter.isCustomDelimiter())
                .isTrue();
        assertThat(delimiter.delimiterExpression())
                .isEqualTo(basicDelimiter + "|" + customDelimiter);

    }

    @Test
    @DisplayName("커스텀구분자가 없을경우 구분자를 가져올떄 기본구분자만 확인된다")
    void 커스텀_구분자_없음() {
        final String text = "1:2,3";

        final Delimiter delimiter = Delimiter.of(text);

        assertThat(delimiter)
                .extracting("custom")
                .isEqualTo("");
        assertThat(delimiter.isCustomDelimiter())
                .isFalse();
        assertThat(delimiter.delimiterExpression())
                .isEqualTo(basicDelimiter);
    }
}
