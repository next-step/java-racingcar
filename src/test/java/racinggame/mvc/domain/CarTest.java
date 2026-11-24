package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("공백만 있는 자동차 이름은 허용하지 않는다.")
    void 공백뿐인_이름을_거절한다() {
        assertThatThrownBy(() -> new Car(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void 이름_길이_제한() {
        assertThatThrownBy(() -> new Car("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5자인 이름을 허용하고 입력한 이름을 반환한다.")
    void 자동차_이름_조회() {
        Car car = new Car("crong");

        assertThat(car.getName()).isEqualTo("crong");
    }

    @Test
    @DisplayName("생성할 때 지정한 위치를 반환한다.")
    void 자동차_위치_조회() {
        Car car = new Car("pobi", 3);

        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력값이 4 미만이면 자동차의 위치가 바뀌지 않는다.")
    void 이동_조건_미만이면_정지한다() {
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(initialPosition);
    }

    @Test
    @DisplayName("입력값이 4 이상이면 자동차가 한 칸 전진한다.")
    void 이동_조건을_충족하면_전진한다() {
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);

        car.move(9);
        assertThat(car.getPosition()).isEqualTo(initialPosition + 2);
    }
}
