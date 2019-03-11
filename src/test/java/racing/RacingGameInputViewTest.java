package racing;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameInputViewTest {
    @Test
    public void 입력값확인()
    {
        HashMap<String,String> inputMap = RacingGameInputView.racingGameInput();

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(inputMap.get("CAR_COUNT")).isEqualTo(in);
    }
}