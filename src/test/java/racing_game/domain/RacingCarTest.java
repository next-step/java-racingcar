package racing_game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing_game.util.Behavior;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    String name;
    RacingCar racingCar;

    @BeforeEach
    void beforeEach() {
        this.name = "pobi";
        this.racingCar = new RacingCar(name);
    }

    @Test
    @DisplayName("레이싱 카 객체 생성")
    void createRacingCar() {
        assertThat(new RacingCar(name)).isInstanceOf(RacingCar.class);
    }

    @Test
    @DisplayName("생성된 레이킹 카의 이름 조회")
    void getName() {
        assertThat(this.racingCar.getName()).isEqualTo(this.name);
    }

    @Test
    @DisplayName("레이싱 카 이름 길이 체크")
    void checkName() {
        assertThatThrownBy(() -> new RacingCar(this.name + this.name)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "정지 - {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(int roundResult) {
        assertThat(this.racingCar.stopOrForward(roundResult)).isEqualTo(Behavior.STOP);
    }

    @ParameterizedTest(name = "전진 - {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void forward(int roundResult) {
        assertThat(this.racingCar.stopOrForward(roundResult)).isEqualTo(Behavior.FORWARD);
    }
}
