package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.movestrategies.RandomMoveStrategy;

class RacingGameTest {

    private RacingGame racingGame;
    private Car[] cars;
    private int numberOfCars = 2;
    private int tries = 3;

    @BeforeEach
    void setUp() {
        RandomMoveStrategy randomMoveStrategy = mock(RandomMoveStrategy.class);
        when(randomMoveStrategy.canIMove())
            .thenReturn(true);
        cars = new Car[]{new Car(randomMoveStrategy), new Car(randomMoveStrategy)};

        racingGame = new RacingGame(numberOfCars, tries) {
            @Override
            protected Car[] createCars(int numberOfCars) {
                return cars;
            }
        };
    }

    @Test
    void 레이싱_결과_테스트() {
        int[] results = racingGame.doRace();

        assertThat(results.length).isEqualTo(numberOfCars);
        assertThat(results[0]).isEqualTo(tries);
        assertThat(results[1]).isEqualTo(tries);
    }

    @Test
    void 자동차_수가_0_또는_음수_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingGame(0, tries);
        }).withMessage("경주할 자동차 수를 정확히 입력하세요.");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingGame(-1, tries);
        }).withMessage("경주할 자동차 수를 정확히 입력하세요.");
    }

    @Test
    void 경주할_거리가_0_또는_음수_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingGame(numberOfCars, 0);
        }).withMessage("경주할 거리를 정확히 입력하세요.");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingGame(numberOfCars, -1);
        }).withMessage("경주할 거리를 정확히 입력하세요.");
    }
}