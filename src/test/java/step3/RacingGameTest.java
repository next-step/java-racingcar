package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.RacingCar;
import step3.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("RacingGameTest 초기화 테스")
    void moveCars() {

        List<RacingCar> racingCarList = new ArrayList<>();
        String[] CarNames = {"pobi", "ggang"};

        RacingGame racingGameTest = new RacingGame(CarNames);
        assertThat(racingGameTest.getRacingCarList()).hasSize(2);
    }
}
