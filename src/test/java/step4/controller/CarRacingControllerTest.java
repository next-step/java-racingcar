package step4.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.view.InputDto;


import static org.assertj.core.api.Assertions.*;

class CarRacingControllerTest {

    @Test
    @DisplayName("쉼표 기준으로 등록된 차 이름을 받으면 CarRacingController 내부에 List<Car> 를 갖도록 해줍니다.")
    void construct() {
        // given
        InputDto inputDto = new InputDto("pobi,crong,honux", 4);
        // when
        CarRacingController result = new CarRacingController(inputDto);
        // then
        assertThat(result.getCarRacingChance()).isEqualTo(4);
        assertThat(result.getCarRacingPlay().getCars()).hasSize(3)
                .extracting("name", "distance")
                .containsExactly(
                        tuple("pobi", 0),
                        tuple("crong", 0),
                        tuple("honux", 0)
                );
    }

    @Test
    @DisplayName("입력받은 차 이름이 5글자를 초과하면 RuntimeException을 보냅니다.")
    void checkCarNameLength() {
        // given
        InputDto inputDto = new InputDto("pobi,cronggggg,honux", 4);
        // when
        // then
        assertThatThrownBy(() -> new CarRacingController(inputDto))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("자동차 이름은 5글자를 초과하면 안됩니다.");
    }
}