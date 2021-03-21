package step03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingEventManagerTest {

    RacingEventManager racingEventManager;

    @BeforeEach
    void setRacingEventManager() {
        racingEventManager = new RacingEventManager("car1", 1);
    }

    @Test
    @DisplayName("중복 승자 출력 테스트")
    void getWinnerRacingCars() {
        RacingCar racingCar1 = new RacingCar("car1", 4);
        RacingCar racingCar2 = new RacingCar("car2", 4);
        RacingCar racingCar3 = new RacingCar("car3", 1);
        RacingCar racingCar4 = new RacingCar("car4", 2);
        List<RacingCar> racingCars = new ArrayList<>(Arrays.asList(racingCar1, racingCar2, racingCar3, racingCar4));

        assertThat(racingEventManager.getWinnerRacingCars(racingCars)).contains(racingCar1, racingCar2);
    }


    @Test
    @DisplayName("racing round 최종 우승 출력 테스트 (중복, 단일)")
    void showRacingFinalWinner() {
        RacingCar racingCar1 = new RacingCar("car1", 4);
        RacingCar racingCar2 = new RacingCar("car2", 4);
        List<RacingCar> winnerRacingCarNames = new ArrayList<>(Arrays.asList(racingCar1, racingCar2));
        List<RacingCar> winnerRacingCarName = new ArrayList<>(Arrays.asList(racingCar1));

        assertThat(racingEventManager.getRacingWinnerName(winnerRacingCarNames)).isEqualTo("car1, car2");
        assertThat(racingEventManager.getRacingWinnerName(winnerRacingCarName)).isEqualTo("car1");
    }
}
