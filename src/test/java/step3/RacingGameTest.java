package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGame {

    @Test
    @DisplayName("RacingGameTest 초기화 테스")
    void move() {

        List<RacingCar> racingCarList = new ArrayList<>();
        RacingGame racingGameTest = new RacingGame(2, racingCarList);

        assertThat(racingCarList.size()).isEqualTo(2);
    }
}
