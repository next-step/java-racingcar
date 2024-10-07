package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.car.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 초기값_0_테스트() {
        Car car = new Car("seou");
        assertThat(car).extracting("position").isEqualTo(0);
    }

    @Test
    @DisplayName("move 메서드는 3 이상인 경우 position은 증가하지 않는다.")
    void 앞으로_이동_4이하() {
        Car car = new Car("baj");
        car.move(3);

        assertThat(car).extracting("position").isEqualTo(0);

    }

    @Test
    @DisplayName("move 메서드는 4 이상인 경우 position이 1증가 된다.")
    void 앞으로_이동_4이상() {
        Car car = new Car("don");
        car.move(6);

        assertThat(car).extracting("position").isEqualTo(1);
    }

    @Test
    @DisplayName("자동차_이름이_5글자_미만_성공")
    void 자동차_이름_5글자_미만_성공() {
        String name = "leo";
        Car car = new Car(name);

        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차_이름이_5글자_초과_에러")
    void 자동차_이름_5글자_초과_에러() {

        assertThatThrownBy(() -> {
            new Car("hanseounggyun");
        }).isInstanceOf(RuntimeException.class).hasMessageMatching("자동차 이름이 5자글자를 초과하였습니다.");
    }

}
