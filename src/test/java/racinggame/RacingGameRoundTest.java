package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.RacingCar.MOVE_THRESHOLD;


class RacingGameRoundTest {
    @Test
    @DisplayName("현재 라운드에 참여한 레이싱카의 목록을 반환한다.")
    void testListSize() {
        final ArrayList<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(new RacingCar(1));
        racingCars.add(new RacingCar(2));
        racingCars.add(new RacingCar(3));

        final RacingGameRound racingGameRound = new RacingGameRound(racingCars, new RacingGameRandomNumber());
        assertThat(racingGameRound.getRacingCars()).hasSize(3);
    }

    @Test
    @DisplayName("각 라운드 별 움직이는 경우 true 를, 움직이지 못한 경우 false 를 반환한다.")
    void testStart() {
        final ArrayList<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(new RacingCar(1));
        racingCars.add(new RacingCar(2));
        racingCars.add(new RacingCar(3));

        final RacingGameRound racingGameRound = new RacingGameRound(racingCars, new RandomNumberGenerator() {
            @Override
            public int generate() {
                return MOVE_THRESHOLD + 1;
            }
        });

        racingGameRound.start();
        assertThat(racingGameRound.isMove(racingCars.get(0))).isTrue();

        final RacingGameRound racingGameRound2 = new RacingGameRound(racingCars, new RandomNumberGenerator() {
            @Override
            public int generate() {
                return MOVE_THRESHOLD - 1;
            }
        });

        racingGameRound2.start();
        assertThat(racingGameRound2.isMove(racingCars.get(0))).isFalse();
    }
}