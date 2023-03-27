package study.racingcartest.view;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    private InputView inputview;

    public static InputStream getInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @DisplayName("게임 횟수 입력체크")
    @ValueSource(strings = {"1"})
    void lottoInputMoney(String input){

        InputStream in = getInput(input);
        System.setIn(in);
        assertThat(inputview.inputGameCnt()).isEqualTo(1);
    }
}
