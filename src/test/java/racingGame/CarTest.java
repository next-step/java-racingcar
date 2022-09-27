package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.racingRule.FowardRule;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private FowardRule fowardRule = new FowardRule();

    @Test
    @DisplayName("움직이는 성공했을시 createTrace를 성공한 만큼 -를 반환")
    void createTrace() {
        Car car = new Car();

        car.move(fowardRule);
        car.move(fowardRule);
        assertThat(car.createTrace("-")).isEqualTo("--");
    }
}