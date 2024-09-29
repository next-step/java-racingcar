package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


class RacingGameRoundTest {
    @Test
    @DisplayName("현재 라운드에 참여한 레이싱카의 목록을 반환한다.")
    void testListSize() {
        final ArrayList<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(new RacingCar(1));
        racingCars.add(new RacingCar(2));
        racingCars.add(new RacingCar(3));

        final RacingGameRound racingGameRound = new RacingGameRound(racingCars);
        assertThat(racingGameRound.getRacingCars()).hasSize(3);
    }
}