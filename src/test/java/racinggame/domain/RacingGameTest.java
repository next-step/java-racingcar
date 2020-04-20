package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;
    private MoveStrategy moveStrategy = new RandomBasedMoveStrategy();

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(Arrays.asList(new String[]{"pobi", "crong", "honux"}), 5);
    }

    @Test
    void createCarsTest() {
        String data = "pobi,crong,honux";
        assertThat(data.split(",").length).isEqualTo(3);    //길이 확인
        assertThat(data.split(",")).containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("3대의 Car, 5번의 Round -> 15줄의 moveResult 생성")
    @Test
    void racingTest() {
        assertThat(racingGame.allRounds(moveStrategy)).hasSize(15);
    }

    @DisplayName("항상 움직일 수 있다고 가정, 모든 차가 1라운드 후 전진했는지 확인")
    @Test
    void everyCarMoveTest() {
        racingGame = new RacingGame(Arrays.asList(new String[]{"pobi", "crong", "honux"}), 1);
        List<Car> allCars = racingGame.allRounds(() -> true);

        assertThat(allCars).allSatisfy(car -> {
            assertThat(car.getPosition()).isEqualTo(1);
        });
    }

    @DisplayName("항상 움직일 수 없다고 가정, 모든 차가 1라운드 후 그대로인지 확인")
    @Test
    void everyCarDoNotMoveTest() {
        racingGame = new RacingGame(Arrays.asList(new String[]{"pobi", "crong", "honux"}), 1);
        List<Car> allCars = racingGame.allRounds(() -> false);

        assertThat(allCars).allSatisfy(car -> {
            assertThat(car.getPosition()).isEqualTo(0);
        });
    }
}
