package car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import car.domain.Car;
import car.util.Movable;
import car.util.NumberGenerator;
import car.util.RandomCarMovable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    @DisplayName("단일 자동차 전진 테스트 정상 동작")
    void 단일_자동차_전진_정상_동작() {
        int amount = 1;
        Car car = new Car("hello");

        car.move(amount);

        Assertions.assertThat(car.getPosition()).isEqualTo(amount);
    }

    @Test
    @DisplayName("Movable 객체가 정해준 만큼 차는 움직인다.")
    void 자동자_움직_가능() {
        // given
        Movable movable = new RandomCarMovable();
        Car car = new Car("hello");
        int decideMoving = movable.decideMoving(NumberGenerator.getRandomNumber());

        car.move(decideMoving);

        assertThat(car).extracting("position").isEqualTo(decideMoving);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("경계, 양 끝단 테스트 : 만약 movable 숫자가 4이상 이면, 자동차는 간다.")
    void 자동자_4이상_일때_움직_가능(int carSpeed) {
        final int CAR_MOVING_SIZE = 1;
        Car car = new Car("hello");
        Movable movable = new RandomCarMovable();

        car.move(movable.decideMoving(carSpeed));

        assertThat(car).extracting("position").isEqualTo(CAR_MOVING_SIZE);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("경계, 양 끝단 테스트 : 만약 movable 숫자가 3이하 이면, 자동차는 간다.")
    void 자동자_3이하_일때_움직_가능(int carSpeed) {
        final int CAR_STOP = 0;
        Car car = new Car("hello");
        Movable movable = new RandomCarMovable();

        car.move(movable.decideMoving(carSpeed));

        assertThat(car).extracting("position").isEqualTo(CAR_STOP);
    }


}
