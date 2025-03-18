package racing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.fake.FakeNumberGenerator;
import racing.model.Cars;

class RaceServiceTest {
    public static final int MOVE_NUMBER = 4;
    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = new RaceService(new FakeNumberGenerator(MOVE_NUMBER));
    }

    @DisplayName("입력 받은 n대의 자동차를 생성 요청 한다.")
    @Test
    void generateCarsTest() {
        // given
        int carCount = 3;

        // when
        Cars cars = raceService.generateCar(carCount);

        // then
        assertThat(cars.getCars().size()).isEqualTo(carCount);
    }

    @DisplayName("자동차 이동을 요청할 수 있다.")
    @Test
    void moveCarTest() {
        // given
        Cars cars = raceService.generateCar(3);

        // when
        raceService.moveCar(cars);

        // then
        assertAll(() -> assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1),
                () -> assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1),
                () -> assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1)
        );

    }
}
