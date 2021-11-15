package step3;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.manager.RacingManager;
import step3.manager.RandomManager;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    private final static RacingManager racingManager = new RandomManager();

    @Test
    @DisplayName("Car 객체 생성시 현재 위치는 0이다.")
    public void newCar() {
        car = new Car(racingManager);

        assertThat(car.currentPosition()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("run을 호출하면 자동차는 전진하거나 멈추거나 둘 중 하나이다.")
    public void carPosition() {
        Condition<Position> go = new Condition<>(
                p -> p.getPosition() == 1, "go");

        Condition<Position> stop = new Condition<>(
                p -> p.getPosition() == 0, "stop");

        car = new Car(racingManager);
        car.run();

        assertThat(car.currentPosition()).is(anyOf(go, stop));
    }
}