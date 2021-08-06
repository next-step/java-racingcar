package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerPolicyImplTest {

    WinnerPolicy winnerPolicy = new WinnerPolicyImpl();

    @DisplayName("우승 주행 거리를 구하는 테스트")
    @Test
    void get_winner_test() {
        RacingCar A = new RacingCar("A", 3);
        RacingCar B = new RacingCar("B", 2);
        RacingCar C = new RacingCar("C", 1);

        List<RacingCar> racingCars = Arrays.asList(A, B, C);

        assertThat(winnerPolicy.winnerDecision(racingCars).get(0).getCarName()).isEqualTo("A");
    }

    @DisplayName("공동 우승자 테스트")
    @Test
    void get_multi_winner_test() {
        RacingCar A = new RacingCar("A", 3);
        RacingCar B = new RacingCar("B", 3);
        RacingCar C = new RacingCar("C", 1);

        List<RacingCar> racingCars = Arrays.asList(A, B, C);

        assertThat(winnerPolicy.winnerDecision(racingCars)).containsExactly(A,B);
    }
}
