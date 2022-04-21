package service;

import domain.TestMoveStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingServiceTest {
    private CarRacingService carRacingService;

    @BeforeEach
    void init() {
        carRacingService = new CarRacingService(TestMoveStrategy.getInstance(true));
    }
    /**
     * Cars에 move, findWinner 테스트를 작성 => CarRacingService 테스트에서는 시도 회수에 관한 테스트 작성.
     */
    @DisplayName("자동차 등록 및 경주 테스트 정상케이스")
    @ParameterizedTest
    @CsvSource(value = {"a,b,c:5", "a,b,c:1000000"}, delimiter = ':')
    void carRegisterTest(String carsName, String attemptCount) {
        assertThat(carRacingService.registerCarsAndStartRacing(carsName, attemptCount));
    }

    @DisplayName("자동차 등록 및 경주 테스트 실패케이스")
    @ParameterizedTest
    @CsvSource(value = {"a,b,c:-1", "a,b,c:3회"}, delimiter = ':')
    void carRegisterFailTest(String carsName, String attemptCount) {
        assertThatThrownBy(() -> carRacingService.registerCarsAndStartRacing(carsName, attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}