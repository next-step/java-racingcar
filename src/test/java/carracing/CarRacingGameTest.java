package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {
    private final Car car = new Car();
    // 0 2 1 8 5 4 9 6 7 3 1 5 1 1 7 3 6 9 4 4 5 1 2 2 6
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(501);
    private final CarRacingGame carRacingGame = new CarRacingGame(3, 501);

    @DisplayName("자동차 한 번 전진 동작 테스트 - 4 미만")
    @Test
    void car_move_below_4() {
        assertThat(car.move(3)).isEqualTo(1);
    }

    @DisplayName("자동차 한 번 전진 동작 테스트 - 4 이상")
    @Test
    void car_move_over_4() {
        assertThat(car.move(4)).isEqualTo(2);
    }

    @DisplayName("랜덤 값에 따른 전진 여부 결정")
    @Test
    void car_move_random() {
        assertThat(car.move(randomNumberGenerator.generateNumber())).isEqualTo(1);
    }

    @DisplayName("자동차 경주 게임 한 라운드 진행")
    @Test
    void play_one_round() {
        assertThat(carRacingGame.playOneRound()).containsExactly(1, 1, 1);
    }

    @DisplayName("자동차 경주 게임 여러 라운드 진행")
    @Test
    void play_several_rounds() {
        assertThat(carRacingGame.playGame(5))
                .containsExactly(
                        List.of(1, 1, 1),
                        List.of(2, 2, 2),
                        List.of(3, 3, 3),
                        List.of(3, 3, 4),
                        List.of(3, 3, 5)
                );
    }
}
