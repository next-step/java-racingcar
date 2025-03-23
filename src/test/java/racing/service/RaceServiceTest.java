package racing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.fake.FakeNumberGenerator;
import racing.domain.Cars;

class RaceServiceTest {
    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = new RaceService(new FakeNumberGenerator(5));
    }

    @DisplayName("입력 받은 n대의 자동차를 생성 요청 한다.")
    @Test
    void generateCarsTest() {
        // given
        List<String> carNames = List.of("BMW", "BENZ", "AUDI");

        // when
        Cars cars = raceService.generateCar(carNames);

        // then
        assertThat(cars.getCars().size()).isEqualTo(carNames.size());
    }

    @DisplayName("자동차 이동을 요청할 수 있다.")
    @Test
    void moveCarTest() {
        // given
        List<String> carNames = List.of("BMW", "BENZ", "AUDI");
        Cars cars = raceService.generateCar(carNames);

        // when
        Cars sut = raceService.moveCar(cars);

        // then
        assertAll(() -> assertThat(sut.getCars().get(0).getPosition()).isEqualTo(2),
                () -> assertThat(sut.getCars().get(1).getPosition()).isEqualTo(2),
                () -> assertThat(sut.getCars().get(2).getPosition()).isEqualTo(2)
        );
    }

}
