package racing.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.fake.FakeNumberGenerator;
import racing.model.Cars;

class RaceServiceTest {
    private static final int MOVE_NUMBER = 4;
    private static final int STOP_NUMBER = 3;
    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
    }

    @DisplayName("입력 받은 n대의 자동차를 생성한다.")
    @Test
    void generateCarsTest() {
        // given
        int carCount = 3;

        // when
        Cars cars = raceService.generateCar(carCount, new FakeNumberGenerator(MOVE_NUMBER));

        // then
        assertThat(cars.size()).isEqualTo(carCount);
    }

    @DisplayName("자동차를 움직일 수 있다.")
    @Test
    void moveCarTest() {
        // given
        Cars cars = raceService.generateCar(3, new FakeNumberGenerator(MOVE_NUMBER));

        // when
        raceService.moveCar(cars);

        // then
        assertThat(cars.getPositions()).isEqualTo(Arrays.asList(1, 1, 1));
    }
}
