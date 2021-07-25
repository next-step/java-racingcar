package step4;

import helper.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private final int numberOfCars = 100;
    private final int numberOfTurns = 100;

    private RacingGame racingGame;

    @BeforeEach
    void init() {
        this.racingGame = new RacingGame(new RacingGameConfiguration(carNames, numberOfCars, numberOfTurns));
    }

    @Test
    @DisplayName("생성자 테스트")
    void gameTest() {
        assertThat(racingGame.getCars().size()).isEqualTo(100);

        racingGame.getCars().forEach(e -> assertThat(e).isExactlyInstanceOf(Car.class));
    }

    @Test
    @DisplayName("턴이 진행되었는지 테스트")
    void nextTurnTest() {
        try {
            TestHelper.invokePrivateMethod(racingGame, "nextTurn");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // 차량이 한칸 이동 (안)했는지 확인
        racingGame.getCars()
                .forEach(car -> assertThat(car.getLocation()).isLessThanOrEqualTo(1));

        // 턴이 진행되었는지 확인
        assertThat(racingGame.getCurrentTurn()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임 진행 테스트")
    void startGameTest() {
        this.racingGame.startGame();

        racingGame.getCars()
                .forEach(car -> assertThat(car.getLocation()).isLessThanOrEqualTo(numberOfTurns));

        assertThat(racingGame.getCurrentTurn()).isEqualTo(numberOfTurns);
    }

}
