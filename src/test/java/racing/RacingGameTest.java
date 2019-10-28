package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private RacingGame racingGame;
    private List<Car> cars = new ArrayList<>();
    private int numberOfCars = 2;
    private int tries = 3;

    @BeforeEach
    void setUp() {
        cars.add(new Car(() -> true));
        cars.add(new Car(() -> true));

        racingGame = new RacingGame(numberOfCars, tries) {
            @Override
            protected List<Car> createCars(int numberOfCars) {
                return cars;
            }
        };
    }

    @Test
    void 레이싱_결과_테스트() {
        racingGame.doRaces();
        List<Car> finished_cars = racingGame.getCars();

        assertThat(finished_cars.size()).isEqualTo(numberOfCars);
        assertThat(finished_cars.get(0).getPosition()).isEqualTo(tries);
        assertThat(finished_cars.get(1).getPosition()).isEqualTo(tries);
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