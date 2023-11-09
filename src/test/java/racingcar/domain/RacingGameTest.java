package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.strategy.RandomMoveStrategyTest;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @DisplayName("입력받은 횟수 만큼 racing 수행 후 종료 확인")
    @ValueSource(ints = {2})
    void racingGame_isEndGame확인(int input) {
        RacingGame racingGame = new RacingGame("a",input);
        for(int i=0; i<input; i++){
            racingGame.start(new RandomMoveStrategyTest(5));
        }
        assertThat(racingGame.isEndGame()).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("racingGame 시작 횟수 차감되는 지 확인")
    @ValueSource(ints = {2})
    void racingGame_시작확인(int input) {
        RacingGame racingGame = new RacingGame("a",input);
        Cars cars = racingGame.start(new RandomMoveStrategyTest(5));
        assertThat(cars.carList().size()).isGreaterThan(0);
    }

    @ParameterizedTest
    @DisplayName("cars반환을 확인")
    @ValueSource(ints = {2})
    void racingGame_cars반환확인(int input) {
        RacingGame racingGame = new RacingGame("a",input);
        assertThat(racingGame.cars()).isNotNull();
        assertThat(racingGame.cars()).isInstanceOf(Cars.class);
    }
}