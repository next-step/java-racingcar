package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 사용자로부터 입력받는 기능
 * <pre>
 *     - 사용자로부터 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력받는다.
 *     - 입력 받은 값을 옵션정보로 생성한다.
 * </pre>
 */
class InputViewTest {

    @Test
    @DisplayName("사용자로부터 입력을 받아 해당 값을 옵션정보로 저장하여 반환합니다.")
    void test1() {
        int carCount = 3, repCount = 5;
        System.setIn(new ByteArrayInputStream(String.format("%s %s", carCount, repCount)
                .getBytes()));
        RacingOptions racingOptions = InputView.showAndGetOptions();
        Assertions.assertAll(
                () -> assertThat(racingOptions.carCount()).isSameAs(carCount),
                () -> assertThat(racingOptions.racingRep()).isSameAs(repCount)
        );
    }
}