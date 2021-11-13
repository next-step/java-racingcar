package step3.domain;

import org.junit.jupiter.api.Test;
import step3.controller.RacingGameController;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameControllerTest {

    @Test
    void 경주_게임을_생성한다() {
        //given
        String names = "java,c++,go";
        //when
        RacingGameController racingGameController = RacingGameController.create(3, names);
        //then
        assertThat(racingGameController).isNotNull();
    }

    @Test
    void 경주를_시작한다() {
        //given
        String names = "java,c++,go";
        //when
        RacingGameController racingGameController = RacingGameController.create(3, names);
        //then
        racingGameController.start();
    }
}
