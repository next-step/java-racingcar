package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.policy.RandomMovingPolicy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private RacingGame racingGame;
    private final int TIME = 3;
    private final int COUNT = 5;
    private final int POSSIBLE_MOVE_MIN_RANGE = 4;
    private final int POSSIBLE_MOVE_MAX_RANGE = 10;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(TIME, COUNT, new RandomMovingPolicy(POSSIBLE_MOVE_MIN_RANGE, POSSIBLE_MOVE_MAX_RANGE));
    }

    @DisplayName("count 만큼 자동차 객체 생성을 성공한다.")
    @Test
    void ready() {
        assertThat(racingGame.getCars()).hasSize(COUNT);
    }

    @DisplayName("최소 한번은 자동차가 이동했음을 성공한다.")
    @Test
    void play() {
        // when
        racingGame.play();

        // then
        for (Car car : racingGame.getCars()) {
            assertThat(car.getDistance()).isGreaterThanOrEqualTo(1);
        }
    }

    @DisplayName("경주 게임 종료를 성공한다.")
    @Test
    void isGameOver() {
        // when
        while(!racingGame.isGameOver()) {
            racingGame.play();
        }

        // then
        assertThat(racingGame.isGameOver()).isTrue();
    }
}