package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.racingRule.FowardRule;
import racingGame.racingRule.NotMoveRule;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private FowardRule fowardRule = new FowardRule();

    @Test
    @DisplayName("move 메서드가 동작하면 -가 담긴다.")
    void move() {
        Car car = new Car();

        car.move();

        assertThat(car.getCarTracesValue(0)).isEqualTo("-");
    }


}