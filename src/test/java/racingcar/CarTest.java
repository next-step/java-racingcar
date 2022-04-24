package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Distance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.CarNameTest.TEST_CAR_NAME;
import static racingcar.DistanceTest.*;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    @Test
    @DisplayName("Car 생성시 CarName 에 null 이 들어오면 오류가 발생한다.")
    void carNameNullTest() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("name is null");

        assertThatThrownBy(() -> new Car(null, TEST_DISTANCE))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("name is null");
    }

    @Test
    @DisplayName("Car 생성시 distance 에 null 이 들어오면 오류가 발생한다.")
    void carDistanceNullTest() {
        assertThatThrownBy(() -> new Car(TEST_CAR_NAME, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("distance is null");
    }

    @Test
    @DisplayName("자동차의 초기 상태는 0이어야 한다.")
    void carDistanceTest() {
        Car car = new Car(TEST_CAR_NAME);

        assertThat(car.distance()).isEqualTo(ZERO);
    }

    @Test
    @DisplayName("자동차 생성시 지정한 이름은 name()을 통해서 얻을 수 있다.")
    void carNameTest() {
        Car car = new Car(TEST_CAR_NAME);

        assertThat(car.name()).isEqualTo(TEST_CAR_NAME);
    }

    @Test
    @DisplayName("자동차가 movable 하다면 한칸 전진한다.")
    void movableTest() {
        Car car = new Car(TEST_CAR_NAME);

        Car nextCar = car.move(() -> true);

        assertThat(nextCar.distance()).isEqualTo(Distance.add(car.distance(), ONE));
    }

    @Test
    @DisplayName("자동차가 unmovable 하다면 멈춰있는다.")
    void unmovableTest() {
        Car car = new Car(TEST_CAR_NAME);

        Car nextCar = car.move(() -> false);

        assertThat(nextCar.distance()).isEqualTo(car.distance());
    }

    @Test
    @DisplayName("입력받은 Distance와 Car가 가진 Distance가 같으면 true를 반환한다.")
    void isSameDistanceTest() {
        Car car = new Car(TEST_CAR_NAME, ONE);

        assertThat(car.isSameDistance(ONE)).isTrue();
    }

    @Test
    @DisplayName("입력받은 Distance와 Car가 가진 Distance가 다르면 false를 반환한다.")
    void isSameDistanceFailTest() {
        Car car = new Car(TEST_CAR_NAME, ONE);

        assertThat(car.isSameDistance(ZERO)).isFalse();
    }
}
