package racingGame.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.car.Car;
import racingGame.model.strategy.RandomMovementStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RacingGameServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    @DisplayName("생성자 메소드는 항상 객체를 생성할 수 있다.")
    public void 생성자_성공_테스트() {
        assertDoesNotThrow(() -> new RacingGameService(new RandomMovementStrategy()));
    }

    @Test
    @DisplayName("moveCarByOneStep 메소드는 입력이 유효한 경우, 1번 움직인다.")
    void moveCarByOneStep_메소드_전진_테스트() {
        RacingGameService gameService = new RacingGameService(() -> true);
        Car car = new Car();

        gameService.moveCarByOneStep(car);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("moveCarByOneStep 메소드는 입력이 유효한 경우, 0번 움직인다.")
    void moveCarByOneStep_메소드_정지_테스트() {
        RacingGameService gameService = new RacingGameService(() -> false);
        Car car = new Car();

        gameService.moveCarByOneStep(car);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
