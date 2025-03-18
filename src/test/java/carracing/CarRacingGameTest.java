package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingGameTest {
    @DisplayName("자동차 한 번 전진 동작 테스트 - 4 미만")
    @Test
    void car_move_below_4() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car)
                .extracting("distance")
                .isEqualTo(1);
    }

    @DisplayName("자동차 한 번 전진 동작 테스트 - 4 이상")
    @Test
    void car_move_over_4() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car)
                .extracting("distance")
                .isEqualTo(2);
    }

    @DisplayName("랜덤 값에 따른 전진 여부 결정")
    @Test
    void car_move_random() {
        Car car = new Car("pobi");
        NumberGenerator testNumberGenerator = new TestNumberGenerator(
                List.of(0, 2, 1, 8, 5, 4, 9, 6, 7, 3, 1, 5, 1, 1, 7, 3, 6, 9, 4, 4, 5, 1, 2, 2, 6)
        );
        car.move(testNumberGenerator.generateNumber());
        assertThat(car)
                .extracting("distance")
                .isEqualTo(1);
    }

    @DisplayName("자동차 경주 게임 한 라운드 진행")
    @Test
    void play_one_round() {
        CarRacingGame carRacingGame = new CarRacingGame(
                "pobi,crong,honux",
                5,
                new TestNumberGenerator(
                        List.of(0, 2, 1, 8, 5, 4, 9, 6, 7, 3, 1, 5, 1, 1, 7, 3, 6, 9, 4, 4, 5, 1, 2, 2, 6)
                )
        );
        assertThat(carRacingGame.playOneRound()).containsExactly("pobi : -", "crong : -", "honux : -");
    }

    @DisplayName("자동차 경주 게임 여러 라운드 진행")
    @Test
    void play_several_rounds() {
        CarRacingGame carRacingGame = new CarRacingGame(
                "pobi,crong,honux",
                5,
                new TestNumberGenerator(
                        List.of(0, 2, 1, 8, 5, 4, 9, 6, 7, 3, 1, 5, 1, 1, 7, 3, 6, 9, 4, 4, 5, 1, 2, 2, 6)
                )
        );
        GameResult gameResult = carRacingGame.playGame();
        assertThat(gameResult.getCarDistances())
                .containsExactly(
                        List.of("pobi : -", "crong : -", "honux : -"),
                        List.of("pobi : -", "crong : -", "honux : -"),
                        List.of("pobi : --", "crong : --", "honux : --"),
                        List.of("pobi : ---", "crong : ---", "honux : ---"),
                        List.of("pobi : ---", "crong : ---", "honux : ----"),
                        List.of("pobi : ---", "crong : ---", "honux : -----")
                );
    }

    @DisplayName("자동차 이름 저장 기능")
    @Test
    void car_name() {
        Car car = new Car("pobi");
        assertThat(car).extracting("name").isEqualTo("pobi");
    }

    @DisplayName("자동차 이름이 5자를 초과하면 안됨")
    @Test
    void car_name_over_5() {
        assertThatThrownBy(() ->
                new CarRacingGame(
                        "abcdef",
                        1,
                        new TestNumberGenerator(List.of(0, 2, 1))
                )
        ).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("우승자 판별 기능 (한명)")
    @Test
    void winner_one() {
        CarRacingGame carRacingGame = new CarRacingGame(
                "pobi,crong,honux",
                5,
                new TestNumberGenerator(
                        List.of(0, 2, 1, 8, 5, 4, 9, 6, 7, 3, 1, 5, 1, 1, 7, 3, 6, 9, 4, 4, 5, 1, 2, 2, 6)
                )
        );

        GameResult gameResult = carRacingGame.playGame();

        assertThat(gameResult.getWinners())
                .containsExactlyInAnyOrder("honux");
    }

    @DisplayName("우승자 판별 기능 (여러명)")
    @Test
    void winner_several() {
        CarRacingGame carRacing = new CarRacingGame(
                "pobi,crong,honux",
                2,
                new TestNumberGenerator(List.of(4, 4, 4, 4, 4, 4))
        );
        GameResult gameResult = carRacing.playGame();
        assertThat(gameResult.getWinners())
                .containsExactlyInAnyOrder("pobi", "crong", "honux");
    }
}
