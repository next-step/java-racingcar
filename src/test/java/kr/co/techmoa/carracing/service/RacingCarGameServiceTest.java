package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.ui.dto.InputDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameServiceTest {

    public RacingCarGameService racingCarGameService = new RacingCarGameService();

    @Test
    void createCar() {
        InputDTO inputDTO = new InputDTO();
        inputDTO.setCarNames("joo,ejf,ifjc");
        inputDTO.setCarNum(3);

        List<Car> createCar = racingCarGameService.createCar(inputDTO);

        assertEquals("joo", createCar.get(0).getCarName());
        assertEquals("ejf", createCar.get(1).getCarName());
        assertEquals("ifjc", createCar.get(2).getCarName());
    }

    @Test
    void createCar_error() {
        InputDTO inputDTO = new InputDTO();
        inputDTO.setCarNames("joo124,ejf,ifjc");
        inputDTO.setCarNum(3);

        assertThatThrownBy(() -> {
            List<Car> createCar = racingCarGameService.createCar(inputDTO);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }
}