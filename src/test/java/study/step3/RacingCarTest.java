package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.util.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱게임 테스트")
public class RacingCarTest {

    @DisplayName("사용자로부터 1회 이상의 게임 횟수를 입력 받는다")
    @Test
    void inputGameCount() {
        assertThatThrownBy(() -> {
            GameConfig gameConfig = new GameConfig(0, 3);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임횟수는 1회 이상이어야 한다");
    }

    @DisplayName("사용자로부터 2대 이상의 자동차 수량을 입력받는다")
    @Test
    void inputCarCount() {
        assertThatThrownBy(() -> {
            GameConfig gameConfig = new GameConfig(2, 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상이어야 한다");
    }

    @DisplayName("0 ~ 9 사이의 random 값을 생성해야 한다")
    @RepeatedTest(100)
    void numberGenerator() {
        int val = NumberGenerator.randomVal(10);

        assertThat(val).isGreaterThan(-1).isLessThan(10);
    }

    @DisplayName("입력값이 4이상의 경우는 전진하고 그외에는 멈춘다")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "4:1", "5:1", "9:1"}, delimiter = ':')
    void carMove(int input, int expected) {
        Car car = new Car();
        car.move(input);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
