package racingcartest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import raingcar.RacingCar;
import raingcar.RacingGame;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingTest {
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    @Test
    void nameTest() {
        RacingCar carRed = new RacingCar("RED");
        assertThat(carRed.getName()).isEqualTo("RED");
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void nameLengTest () {
        Throwable thrown = catchThrowable(() -> { RacingCar carRed = new RacingCar("READBA"); });
        assertThat(thrown).isInstanceOf(Exception.class)
                .hasMessageContaining("자동차 이름은 5자 이하 입니다.");
    }

    @DisplayName("전진하는 조건은 무작위 값이 4 이상일 경우이다.")
    @Test
    void moveTest () {
        RacingCar carRed = new RacingCar("RED");
        assertThat(carRed.move(4)).isEqualTo(false);
        assertThat(carRed.move(5)).isEqualTo(true);
    }

    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다.")
    @Test
    void racingGameTest () {
        RacingGame game = new RacingGame("RED, BLUE, GREEN", 5);
        assertThat(game.getCars().size()).isEqualTo(3);
    }

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @Test
    void racingGameTest2 () {
        RacingGame game = new RacingGame("RED, BLUE, GREEN", 5);
        assertThat(game.play()).isEqualTo(5);
    }
}
