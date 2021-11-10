package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameConfigDto;

class InputViewTest {

    @Test
    @DisplayName("initConfig 메소드 호출시, GameConfigDto 객체를 반환 한다.")
    void initConfigTest() {
        Assertions.assertThat(InputView.initConfig())
            .isInstanceOf(GameConfigDto.class);
    }


}