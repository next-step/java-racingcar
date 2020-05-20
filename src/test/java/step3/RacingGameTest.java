package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
