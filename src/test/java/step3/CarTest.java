package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarTest {

    private final Car car = new Car(new RandomStrategy());

    @Test
    public void 자동차를_처음_생성하면_현재_위치는_0이다() {
        assertThat(car.location()).isEqualTo(0);
    }
}
