package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.ui.dto.InputDTO;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameServiceTest {

    @Test
    void 자동차이름_생성_test() {
        InputDTO inputDTO = new InputDTO();
        inputDTO.setCarNames("joo,ejf,ifjc");
        inputDTO.setCarNum(3);
        RacingCarGameService racingCarGameService = new RacingCarGameService(inputDTO);

        List<Car> createCar = racingCarGameService.createCar();

        assertEquals("joo", createCar.get(0).getCarName());
        assertEquals("ejf", createCar.get(1).getCarName());
        assertEquals("ifjc", createCar.get(2).getCarName());
    }

    @Test
    void 자동차이름_생성_error() {
        InputDTO inputDTO = new InputDTO();
        inputDTO.setCarNames("joo124,ejf,ifjc");
        inputDTO.setCarNum(3);

        RacingCarGameService racingCarGameService = new RacingCarGameService(inputDTO);

        assertThatThrownBy(() -> {
            racingCarGameService.createCar();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 라운드_생성_확인() {
        InputDTO inputDTO = new InputDTO();
        inputDTO.setCarNames("joo,ejf,ifjc");
        inputDTO.setCarNum(3);
        inputDTO.setTryNumber(4);

        RacingCarGameService racingCarGameService = new RacingCarGameService(inputDTO);
        List<List<Car>> cars = racingCarGameService.createRound();

        assertEquals(4, cars.size());

    }


}