package game.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * 사용자로부터 입력받는 기능
 * <pre>
 *     - 사용자로부터 콤마(,)로 구분된 자동차 이름을 입력받는다.
 *     - 사용자로부터 시도할 수를 입력받는다.
 * </pre>
 */
class InputViewTest {

    @Test
    @DisplayName("사용자로부터 콤마로 구분된 자동차 이름과 시도할 경기 수를 입력 받아, 해당 값들을 각각 반환합니다.")
    void test1() {
        // given
        String inputCarNames = "red,orange,yellow";
        String inputRep = "5";
        String inputs = String.format("%s\n%s", inputCarNames, inputRep);

        // when
        System.setIn(new ByteArrayInputStream(inputs.getBytes()));
        List<String> carNames = InputView.showAndGetCarNames();
        int racingRep = InputView.showGameCountConsole();

        // then
        assertAll(
                () -> assertThat(carNames).isEqualTo(List.of(inputCarNames.split(","))),
                () -> assertThat(racingRep).isSameAs(Integer.parseInt(inputRep))
        );
    }

}