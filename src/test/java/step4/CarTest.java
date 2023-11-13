package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.model.Car;
import step4.model.Races;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차가 앞으로 전진하는지 확인한다.")
    void carGoTest() {
        Car car = new Car("tester1", 0);
        assertThat(car.getCurrentStatus()).isEqualTo(0);

        Races races = new Races(List.of("tester1"));
        races.start(new ForwardMoveStrategy());
        car.go();
        assertThat(car.getCurrentStatus()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 멈춰야 할 경우를 확인한다.")
    void carDoNotGoTest() {
        Car car = new Car("tester1", 0);
        assertThat(car.getCurrentStatus()).isEqualTo(0);

        Races races = new Races(List.of("tester1"));
        races.start(new StopMoveStrategy());

        assertThat(car.getCurrentStatus()).isEqualTo(0);
    }
}
