package racing.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.car.Car;
import racing.car.game.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class RacingGameTest {
    private RacingGame game;

    @BeforeEach
    void setUp() {
        game = new RacingGame();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5})
    @DisplayName("initializeCars 메서드는 각 Car 객체를 올바르게 초기화해야 한다.")
    void initializeCars_메서드_테스트(int carCount) {
        Car[] cars = new Car[carCount];
        game.initializeCars(carCount, cars);

        for (int i = 0; i < carCount; i++) {
            assertThat(cars[i]).isNotNull();
        }
    }

    @Test
    @DisplayName("validateCarCount 메서드는 유효한 자동차 개수 입력 시 해당 값을 반환해야 한다.")
    void validateCarCount_메서드_테스트_성공() {
        int carCount = 3;
        int result = game.validateCarCount(carCount);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("validateCarCount 메서드는 자동차 개수가 2 미만일 경우 예외를 발생시켜야 한다.")
    void validateCarCount_메서드_테스트_실패() {
        int carCount = 0;

        assertThatThrownBy(() -> {
            game.validateCarCount(carCount);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("게임을 진행하려면 자동차가 최소 2대 있어야 합니다.");

    }

    @Test
    @DisplayName("validateTryCount 메서드는 유효한 시도 횟수 입력 시 해당 값을 반환해야 한다.")
    void validateTryCount_메서드_테스트_성공() {
        int tryCount = 5;
        int result = game.validateTryCount(tryCount);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("validateTryCount 메서드는 시도 횟수가 1 미만일 경우 예외를 발생시켜야 한다.")
    void validateTryCount_메서드_테스트_실패() {
        int tryCount = 0;

        assertThatThrownBy(() -> {
            game.validateTryCount(tryCount);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("게임을 진행하려면 시도 횟수는 1 이상이어야 합니다.");
    }
}
