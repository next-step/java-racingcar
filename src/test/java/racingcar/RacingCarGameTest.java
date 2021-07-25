package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {
    private final List<RacingCar> racingCars = new ArrayList<>();

    @Test
    @DisplayName("레이싱 카의 차량대수로 초괴화를 했을 때 리스트의 사이즈가 변하는 것을 확인한다.")
    void initializeRacingCars() {
        assertThat(racingCars.size()).isZero();
        int carNumber = 5;
        RacingCarGame.initializeRacingCars(racingCars, carNumber);
        assertThat(racingCars.size()).isEqualTo(carNumber);
    }

}