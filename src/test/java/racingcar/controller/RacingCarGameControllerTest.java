package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.RacingCarRequestDto;
import racingcar.domain.request.Amount;
import racingcar.domain.request.Round;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameControllerTest {

    private RacingCarRequestDto requestDto;

    @BeforeEach
    void setUp() {
        Amount amount = Amount.from(1);
        Round round = Round.from(1);
        requestDto = RacingCarRequestDto.of(amount, round);
    }


    @DisplayName("RacingCarGameController 가 생성되는지 확인하는 테스트")
    @Test
    void RacingCarGameController_CreateTest(){
        // given and when
        RacingCarGameController controller = RacingCarGameController.from(requestDto);

        //then
        assertThat(controller).isNotNull();
    }

}