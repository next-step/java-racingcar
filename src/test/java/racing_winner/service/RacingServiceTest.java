package racing_winner.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_winner.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private RacingService racingService = new RacingService();
    private List<RacingCar> racingCarList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        int round = 3;
        String carNames = "pobi,crong,honux";

        racingCarList = racingService.setInitialCarList(round,carNames);
    }

    @Test
    @DisplayName("입력된 수만큼 리스트가 생성되는지 확인")
    void setInitialCarList() {
        assertThat(racingCarList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void findWinners() {
        racingCarList.get(0).move();
        racingCarList.get(2).move();

        String winner = racingService.findWinners(racingCarList);

        assertThat(winner).isEqualTo("pobi, honux");

    }
}