package racinggame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.vo.Car;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingCarGameTest {

    private RacingCarGame racingCarGame;

    @BeforeAll
    void setUp() {
        this.racingCarGame = new RacingCarGame();
    }

    @DisplayName("자동차 대수 만큼 생성 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void createCars(String carsName) {
        Map<Integer, Car> carMap;
        carMap = racingCarGame.createCars(carsName);
        assertThat(carMap).hasSize(3);
    }

    @DisplayName("자동차를 움직일 수 있는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    void canMoveCar(int random) {
        boolean canMove = racingCarGame.canMove(random);
        if (random > 4) {
            assertThat(canMove).isTrue();
        }
        assertThat(canMove).isFalse();
    }

}
