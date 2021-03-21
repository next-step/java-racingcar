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
        RacingCar racingCar1 = new RacingCar("test1", 4);
        RacingCar racingCar2 = new RacingCar("test2", 4);
        RacingCar racingCar3 = new RacingCar("test3", 1);
        RacingCar racingCar4 = new RacingCar("test4", 2);
        List<RacingCar> racingCars = new ArrayList<>(Arrays.asList(racingCar1, racingCar2, racingCar3, racingCar4));

        assertThat(racingEventManager.getWinnerRacingCars(racingCars)).contains(racingCar1, racingCar2);
    }
}
