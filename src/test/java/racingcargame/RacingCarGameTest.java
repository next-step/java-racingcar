package racingcargame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.fake.FakeFailMoveRandomOption;
import racingcargame.fake.FakeSuccessMoveRandomOption;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameTest {
    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        racingCarGame = new RacingCarGame("a,b,c",1);
    }

    @DisplayName("입력한 자동차 수 만큼 자동차 객체를 생성한다.")
    @Test
    void createCar() {
       assertEquals(racingCarGame.getCars().size(), 3);
    }

    @DisplayName("자동차 게임 경주를 통해 자동차들이 움직임을 확인할 수 있다.")
    @Test
    void startGame_move() {
        RandomOption movableOption = new FakeSuccessMoveRandomOption();
        int expected = 1;

        racingCarGame.startGame(movableOption);
        List<RacingCar> cars = racingCarGame.getCars();

        for (RacingCar actual : cars) {
            assertEquals(expected, actual.getDistance());
        }
    }

    @DisplayName("자동차 게임 경주를 통해 자동차들이 멈춤을 확인할 수 있다.")
    @Test
    void startGame_stop() {
        RandomOption stoppableOption = new FakeFailMoveRandomOption();
        int expected = 0;

        racingCarGame.startGame(stoppableOption);
        List<RacingCar> cars = racingCarGame.getCars();

        for (RacingCar actual : cars) {
            assertEquals(expected, actual.getDistance());
        }
    }
}
