package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @ParameterizedTest
    @CsvSource(value = {"2,시도할 회수는 몇 회 인가요?", "1,자동차 대수는 몇 대 인가요?", "3,잘못된 인자입니다."})
    void Check_String_How_Many_Cars_Or_How_Many_Trials(String value, String expected) {
        assertThat(InputView.askQuestion(value)).isEqualTo(expected);
    }
}
