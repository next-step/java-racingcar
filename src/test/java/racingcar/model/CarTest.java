package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    @Test
    void tryToMove_자동차가_움직인다() {
        Car car = new Car(0, "wu2ee");
        car.tryToMove(() -> 5);
        assertThat(car.getMoveDistance().getNumber()).isEqualTo(1);
    }

    @Test
    void tryToMove_자동차가_움직이지_않는다() {
        Car car = new Car(0, "wu2ee");
        car.tryToMove(() -> 3);
        assertThat(car.getMoveDistance().getNumber()).isZero();
    }

    @Test
    void Car_처음에_움직인상태에서_다음시도에_자동차가_움직인다() {
        Car car = new Car(1, "wu2ee");
        car.tryToMove(() -> 4);
        assertThat(car.getMoveDistance().getNumber()).isEqualTo(2);
    }

    @Test
    void Car_처음에_움직인상태에서_다음시도에_자동차가_움직이지_않는다() {
        Car car = new Car(1, "wu2ee");
        car.tryToMove(() -> 3);
        assertThat(car.getMoveDistance().getNumber()).isEqualTo(1);
    }

    @Test
    void getMoveDistanceTrace_자동차_움직인_거리를_추적한다() {
        Car car = new Car(0, "wu2ee");
        car.tryToMove(() -> 6);
        car.tryToMove(() -> 3);
        car.tryToMove(() -> 8);
        car.tryToMove(() -> 4);
        car.tryToMove(() -> 0);
        assertThat(car.getMoveDistanceTrace().stream().map(PositiveNumber::getNumber).collect(Collectors.toList())).containsExactly(1, 1, 2, 3, 3);
    }

    @Test
    void Identity_자동차는_이름을_갖는다() {
        String carName = "wu2ee";
        Car car = new Car(0, carName);
        assertThat(car.getId().getIdentity()).isEqualTo(carName);
    }

    @Test
    void Identity_자동차_이름은_5자를_초과할수없다() {
        String carName = "wu2eee";
        assertThatThrownBy(() -> {
            new Car(0, carName);
        }).isInstanceOf(RuntimeException.class);
    }
}