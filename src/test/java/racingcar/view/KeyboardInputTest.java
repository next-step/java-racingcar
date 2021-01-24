package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyboardInputTest {

    private Input input;

    @DisplayName("comma를 포함한 자동차 이름들을 인자로 받아 리스트 형태로 출력")
    @Test
    void getCarNames() {
        // given
        String inputString = "abc,def,ghi";
        provideInput(inputString);

        // when
        List<String> carNames = input.getCarNames();

        // then
        assertThat(carNames.get(0)).isEqualTo("abc");
        assertThat(carNames.get(1)).isEqualTo("def");
        assertThat(carNames.get(2)).isEqualTo("ghi");
    }

    @DisplayName("숫자를 잘 입력받는지 확인한다")
    @Test
    void getRounds() {
        // given
        String inputString = "1";
        provideInput(inputString);

        // when
        int result = input.getRounds();

        // then
        assertThat(result).isEqualTo(Integer.parseInt(inputString));
    }

    private void provideInput(final String inputString) {
        input = new KeyboardInput(new ByteArrayInputStream(inputString.getBytes()));
    }
}
