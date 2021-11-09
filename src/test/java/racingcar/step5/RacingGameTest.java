package racingcar.step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step5.config.MoveConfig;
import racingcar.step5.domain.Car;
import racingcar.step5.domain.Cars;
import racingcar.step5.domain.MovingStrategy;
import racingcar.step5.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    MovingStrategy moving;

    @BeforeEach
    void init() {
        MoveConfig moveConfig = new MoveConfig();
        moving = moveConfig.move();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("시도 횟수 값은 0 이하 값이 들어오면 안된다")
    void inputValidation(int value) {
        assertThatThrownBy(() -> new RacingGame("K3,k5", value))
                .isInstanceOf(IllegalArgumentException.class);
        //값 정상
        assertThatCode(() -> new RacingGame("K3,k5", 1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("랜덤값 - 레이스 테스트")
    void race() {
        RacingGame racingGame = new RacingGame("K3,k5", 10);
        racingGame.race(moving);
        assertThat(racingGame.getCountOfTry()).isEqualTo(9);
        assertThat(racingGame.isEndGame()).isFalse();
    }

    @Test
    @DisplayName("랜덤값 - 종료 테스트")
    void endGame() {
        RacingGame racingGame = new RacingGame("K3,k5", 10);
        for (int i = 0; i < 10; i++) {
            racingGame.race(moving);
        }
        assertThat(racingGame.isEndGame()).isTrue();
    }

    @Test
    @DisplayName("자동차 이름을 구분자로 쪼개기")
    void nameSplit() {
        String[] arr = {"k3", "k5", "k7"};
        RacingGame racingGame = new RacingGame("k3,k5,k7", 5);
        assertThat(racingGame.getCars().equals(new Cars(arr))).isTrue();
    }

    @Test
    @DisplayName("레이스 종료 후 위너 찾기")
    void findWinners() {
        Car K3 = new Car("K3", 12);
        Car K5 = new Car("K5", 11);
        Car K7 = new Car("K7", 3);
        Car K9 = new Car("K9", 12);
        Cars cars = new Cars(K3, K5, K7, K9);
        RacingGame racingGame = new RacingGame(cars, 5);
        List<Car> winners = racingGame.findWinners();
        assertThat(winners.contains(new Car("K3"))).isTrue();
        assertThat(winners).contains(new Car("K9"));
        assertThat(winners).doesNotContain(new Car("K5"));
        assertThat(winners.size()).isEqualTo(2);
    }

}
