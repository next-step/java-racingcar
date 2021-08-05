package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @DisplayName("숫자를 하이픈으로 변경하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2,--", "5,-----"})
    public void convertNumberToHyphenTest(int number, String hyphen) {
        String result = ResultView.convertPositionToHyphen(number);
        assertThat(result).isEqualTo(hyphen);

    }
}
