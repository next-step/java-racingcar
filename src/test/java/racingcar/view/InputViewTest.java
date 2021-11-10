package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameConfigDto;

class InputViewTest {


    @BeforeEach
    void init() throws IOException {
        // MOCK System.in
        String data = "3\r\n3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

    }

    @Test
    @DisplayName("initConfig 메소드 호출시, GameConfigDto 객체를 반환 한다.")
    void initConfigTest() {

        InputView inputView = new InputView();

        assertThat(inputView.initConfig())
            .isInstanceOf(GameConfigDto.class);
    }


}