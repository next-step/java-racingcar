package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author : yusik
 * @date : 2019/10/27
 */
public class InputViewTest {

    @DisplayName("입력 값 출력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"test:test", "111:111"}, delimiter = ':')
    void getInput(String input, String output) {

        // given
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputView inputView = new InputView(in) {
            @Override
            public void initialize(UserInputs userInput) {
                userInput.addInputMessage("testKey", "메시지 출력 테스트");
            }
        };

        // when
        inputView.renderAndAcceptInput();

        //then
        assertThat(inputView.getInputValueByKey("testKey")).isEqualTo(output);

    }
}
