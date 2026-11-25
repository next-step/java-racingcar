package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("입력한 자동차 이름을 반환한다.")
    void 자동차_이름_조회() {
        Car car = new Car("crong");

        assertThat(car.getName()).isEqualTo("crong");
    }

    @Test
    @DisplayName("생성할 때 지정한 위치를 반환한다.")
    void 자동차_위치_조회() {
        Car car = new Car(new CarName("pobi"), new Position(3));

        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("상대보다 더 멀리 간 자동차를 확인한다.")
    void 상대보다_멀리_갔는지_확인한다() {
        Car ahead = new Car("pobi", 4);
        Car behind = new Car("crong", 2);

        assertThat(ahead.isFartherThan(behind)).isTrue();
        assertThat(behind.isFartherThan(ahead)).isFalse();
    }

    @Test
    @DisplayName("서로 다른 자동차가 같은 위치에 있는지 확인한다.")
    void 같은_위치인지_확인한다() {
        Car pobi = new Car("pobi", 4);
        Car crong = new Car("crong", 4);
        Car honux = new Car("honux", 2);

        assertThat(pobi.hasSamePositionAs(crong)).isTrue();
        assertThat(pobi.hasSamePositionAs(honux)).isFalse();
        assertThat(pobi.isFartherThan(crong)).isFalse();
    }

    @Test
    @DisplayName("입력값이 4 미만이면 자동차의 위치가 바뀌지 않는다.")
    void 이동_조건_미만이면_정지한다() {
        int initialPosition = 2;
        Car car = new Car("pobi", initialPosition);

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(initialPosition);
    }

    @Test
    @DisplayName("입력값이 4 이상이면 자동차가 한 칸 전진한다.")
    void 이동_조건을_충족하면_전진한다() {
        Position position = new Position(0);
        Car car = new Car(new CarName("pobi"), position);
        int initialPosition = car.getPosition();

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);

        car.move(9);
        assertThat(car.getPosition()).isEqualTo(initialPosition + 2);
        assertThat(position.getValue()).isEqualTo(initialPosition + 2);
    }
}
