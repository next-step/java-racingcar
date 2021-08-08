package racing_winner.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    private Racing racing;

    @BeforeEach
    void setRacingCar(){
        String[] racingCars = new String[]{"pobi", "crong", "honux"};
        racing = Racing.setRacingCars(racingCars);
    }

    @Test
    @DisplayName("입력한 자동차 수 만큼 생성됐는지 테스트")
    void getRacingNumber() {
        assertThat(racing.getRacingNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("경기 후 우승자 찾기 테스트")
    void findWinners() {
        racing.move(() -> true);

        List<Car> winner = racing.findWinners();
        assertThat(winner.size()).isEqualTo(3);
    }

}