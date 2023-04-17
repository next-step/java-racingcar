package race.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.car.dto.CarInfoDto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    final int carCount = 5;
    final int matchCount = 4;
    final String TEST_CAR_NAME = "TEST_CAR_NAME";
    final List<String> carNames = new ArrayList<>();
    Racing racing;

    @BeforeEach
    void setUp() {
        for (int i = 0; i < carCount; i++) {
            this.carNames.add(this.TEST_CAR_NAME);
        }

        this.racing = new Racing(matchCount, carNames);
    }

    @Test
    @DisplayName("레이싱에 참여하는 자동차의 댓수 식별")
    void racingCarCount() {
        System.out.println(carNames);

        assertThat(racing)
                .extracting("racingCars")
                .extracting("racingCars")
                .asList()
                .hasSize(carCount);
    }

    @Test
    @DisplayName("레이스 정보의 매치 횟수와 자동차 갯수 확인")
    void race() {
        final List<List<CarInfoDto>> carLocations = racing.race();

        assertThat(carLocations)
                .hasSize(matchCount)
                .map(List::size)
                .containsExactly(carCount, carCount, carCount, carCount);

    }
}
