package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Car;
import step4.model.Name;
import step4.model.Position;
import step4.model.Races;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"tester1"})
    @DisplayName("자동차가 앞으로 전진하는지 확인한다.")
    void carGoTest(String carName) {
        Car car = new Car(new Name(carName), new Position(0));
        assertThat(car.getPosition().getCurrentStatus()).isEqualTo(0);

        Races races = new Races(List.of(carName));
        races.start(new ForwardMoveStrategy());
        assertThat(car.getPosition().getCurrentStatus()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"tester1"})
    @DisplayName("자동차가 멈춰야 할 경우를 확인한다.")
    void carDoNotGoTest(String carName) {
        Car car = new Car(new Name(carName), new Position(0));
        assertThat(car.getPosition().getCurrentStatus()).isEqualTo(0);

        Races races = new Races(List.of(carName));
        races.start(new StopMoveStrategy());

        assertThat(car.getPosition().getCurrentStatus()).isEqualTo(0);
    }
}
