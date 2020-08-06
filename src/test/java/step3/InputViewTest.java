package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    private InputView question = new InputView();

    @ParameterizedTest
    @CsvSource(value = {"2,시도할 회수는 몇 회 인가요?", "1,자동차 대수는 몇 대 인가요?"})
    void Check_String_How_Many_Cars_Or_How_Many_Trials(String value, String expected) {
        assertThat(question.askQuestion(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,4,4", "2,3,3"})
    void Record_Cars_In_InputView(String qNumber, int input, int expected) {
        question.enterAnswerForQuestion(qNumber, input);
        assertThat(question.getAnswer(qNumber)).isEqualTo(expected);
    }
}
