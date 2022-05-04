package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.MovableStrategy;
import racing.domain.NumberProvider;
import racing.domain.RandomNumMovableStrategy;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Random random = new Random();

    @Test
    @DisplayName("4이상의 숫자가 전달되면 한번 전진한다.")
    void 움직임_테스트() {

        NumberProvider numberProvider = () -> random.nextInt(6)+4;
        ;
        MovableStrategy movableStrategy = new RandomNumMovableStrategy(numberProvider);


        Car car = new Car(movableStrategy, "name");

        assertThat(car.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("3이하 숫자가 전달되면 움직이지 않는다.")
    void 멈춤_테스트() {

        NumberProvider numberProvider = () -> random.nextInt(4);
        MovableStrategy movableStrategy = new RandomNumMovableStrategy(numberProvider);


        Car car = new Car(movableStrategy, "name");

        assertThat(car.move()).isEqualTo(0);

        assertThat(car.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("0~9 사이의 숫자가 아니라면 예외발생")
    void 움직임_숫자범위예외발생_테스트() {

        NumberProvider numberProvider = () -> -1;
        MovableStrategy movableStrategy = new RandomNumMovableStrategy(numberProvider);


        Car car = new Car(movableStrategy, "name");
        assertThatThrownBy(car::move).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(car::move).isInstanceOf(IllegalArgumentException.class);
    }
}

