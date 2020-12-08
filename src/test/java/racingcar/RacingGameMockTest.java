package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameMockTest {

    private RacingGame racingGame;

    @BeforeEach
    void init() {
        Map<Integer, List<RacingCar>> racingCarMap = new HashMap<>();
        racingCarMap.put(1,
                Arrays.asList(
                        new RacingCar(3, new CarName("pobi")).race(new int[]{1, 2, 4}),  // -
                        new RacingCar(3, new CarName("crong")).race(new int[]{1, 2, 4}),  // -
                        new RacingCar(3, new CarName("honux")).race(new int[]{1, 4, 4})  // --
                ));
        racingCarMap.put(2,
                Arrays.asList(
                        new RacingCar(3, new CarName("pobi")).race(new int[]{4, 4, 4}),  // ---
                        new RacingCar(3, new CarName("crong")).race(new int[]{1, 2, 4}),  // -
                        new RacingCar(3, new CarName("honux")).race(new int[]{1, 2, 4})  // -
                ));
        racingCarMap.put(3,
                Arrays.asList(
                        new RacingCar(3, new CarName("pobi")).race(new int[]{1, 4, 4}),  // --
                        new RacingCar(3, new CarName("crong")).race(new int[]{1, 4, 4}),  // --
                        new RacingCar(3, new CarName("honux")).race(new int[]{4, 4, 4})  // ---
                ));
        racingGame = new RacingGameMock(3, 3, racingCarMap);
    }

    @Test
    void race() {
        RacingCar racingCar = racingGame.getRacingCarMap().get(3).get(2);
        assertThat(racingCar.getAdvancedCount()).isEqualTo(3);
    }

    @Test
    void raceWithCarName() {
        RacingCar racingCar = racingGame.getRacingCarMap().get(3).get(2);
        assertThat(racingCar.getAdvancedCount()).isEqualTo(3);
        assertThat(racingCar.getCarName().getName()).isEqualTo("honux");
    }

    @Test
    void pickWinners() {
        racingGame.pickWinner();
        assertThat(racingGame.getWinners()).isEqualTo(Arrays.asList(
                new RacingCar(3, new CarName("pobi")).race(new int[]{4, 4, 4}),
                new RacingCar(3, new CarName("honux")).race(new int[]{4, 4, 4})
        ));
    }
}
