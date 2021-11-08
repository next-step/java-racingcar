package carracing.service;

import static org.assertj.core.api.Assertions.assertThat;

import carracing.model.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarRacingServiceTest {

    private static final Integer CAR_COUNT = 5;

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(CAR_COUNT);

    }

    @ParameterizedTest
    @DisplayName("자동차 경주 시도 횟수 일치 확인")
    @ValueSource(ints = 10)
    void tryCountEqualsTotalCount(Integer tryCount) {
        CarRacingService carRacingService;
        carRacingService = new CarRacingService(cars, tryCount);
        carRacingService.gameStart();

        assertThat(cars.getTryTotalCount()).isEqualTo(tryCount);
    }

}
