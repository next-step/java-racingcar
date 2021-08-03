package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerPolicyImplTest {

    private final List<RacingCar> racingCars = new ArrayList<>();
    WinnerPolicy winnerPolicy = new WinnerPolicyImpl();

    @BeforeEach
    void setUp() {
        RacingCar A = new RacingCar("A");
        A.goForward(5);
        A.goForward(5);
        A.goForward(5);

        RacingCar B = new RacingCar("B");
        B.goForward(5);
        B.goForward(5);

        RacingCar C = new RacingCar("C");
        C.goForward(5);

        racingCars.add(A);
        racingCars.add(B);
        racingCars.add(C);
    }

    @DisplayName("우승 주행 거리를 구하는 테스트")
    @Test
    void get_winner_test() {
        assertThat(winnerPolicy.winnerDecision(racingCars).get(0).getCarName()).isEqualTo("A");
    }

    @DisplayName("공동 우승자 테스트")
    @Test
    void get_multi_winner_test() {
        racingCars.get(1).goForward(5);
        assertThat(winnerPolicy.winnerDecision(racingCars).get(0).getCarName()).isEqualTo("A");
        assertThat(winnerPolicy.winnerDecision(racingCars).get(1).getCarName()).isEqualTo("B");
    }
}
