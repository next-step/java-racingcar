package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.dto.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RacingCarServiceTest {
    private static final int CAR_COUNT = 3;

    private RacingCarService racingCarService;

    @BeforeEach
    void setup() {
        racingCarService = RacingCarService.init(CAR_COUNT);
    }

    @Test
    @DisplayName("정상적으로 Cars 정보를 가지고 오는지 확인")
    void getCars() {
        Cars cars = racingCarService.start();
        assertNotNull(cars);
        assertThat(cars.getPositions().size()).isEqualTo(CAR_COUNT);
    }
}
