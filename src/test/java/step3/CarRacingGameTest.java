package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.factory.CarFactory;
import step3.service.CarRacingGame;

@DisplayName("자동차 경주 게임 테스트")
public class CarRacingGameTest {

    private CarRacingGame carRacingGame;

    @BeforeEach
    public void setUp() {
        carRacingGame = new CarRacingGame(CarFactory.create(5), 3);
    }

    @Test
    @DisplayName("자동차 경주 게임 시작")
    public void start() {
        carRacingGame.start();
    }

    @Test
    @DisplayName("스코어 보드에 기록")
    public void recordScoreboard() {
        carRacingGame.recordScoreboard();
    }

}
