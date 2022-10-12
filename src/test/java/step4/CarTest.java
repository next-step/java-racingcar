package step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarTest {

    @Test
    public void 자동차를_처음_생성하면_현재_위치는_0이다() {
        Car car = new Car("test", new RandomStrategy());
        assertThat(car.location()).isEqualTo(0);
    }

    @Test
    public void 자동차가_움직일_수_있는_경우_위치가_1_증가한다() {
        Car car = new Car("test", new MoveStrategy());
        car.moveOrStop();
        assertThat(car.location()).isEqualTo(1);
    }

    @Test
    public void 자동차가_움직일_수_없는_경우_위치는_그대로이다() {
        Car car = new Car("test", new StopStrategy());
        car.moveOrStop();
        assertThat(car.location()).isEqualTo(0);
    }

    @Test
    public void 자동차는_위치_값이_큰_것이_더_큰_객체라고_판단한다() {
        Car car1 = new Car("test", new MoveStrategy());
        Car car2 = new Car("test", new StopStrategy());
        car1.moveOrStop();
        assertTrue(car1.compareTo(car2) > 0);
    }
}
