package racing_winner.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_winner.domain.RacingCar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private RacingService racingService = new RacingService();

    @Test
    @DisplayName("입력된 수만큼 리스트가 생성되는지 확인")
    void setInitialCarList() {
        int round = 3;
        String carNames = "pobi,crong,honux";

        List<RacingCar> racingCarList = racingService.setInitialCarList(round,carNames);
        assertThat(racingCarList.size()).isEqualTo(3);
    }

}