package carracing.service;

import static org.assertj.core.api.Assertions.assertThat;

import carracing.model.Cars;
import carracing.model.ui.InputDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingServiceTest {

    private static final Integer TRY_COUNT = 5;

    private InputDto inputDto;

    @BeforeEach
    void setUp() {
        String carsName = "dong,hyo,kim";
        inputDto = InputDto.of(carsName, TRY_COUNT);
    }

    @Test
    @DisplayName("자동차 경주 시도 횟수 일치 확인")
    void tryCountEqualsTotalCount() {
        CarRacingService carRacingService;
        carRacingService = new CarRacingService(inputDto);
        Cars cars = carRacingService.gameStart();

        assertThat(cars.getTryTotalCount()).isEqualTo(TRY_COUNT);
    }

}
