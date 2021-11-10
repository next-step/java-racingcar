package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void 자동차_생성_성공() {
        Car car = new Car("chang");
        assertThat(car).isEqualTo(new Car("chang"));
    }

    @Test
    void 자동차_생성_실패() {
        assertThatThrownBy(() -> {
            new Car("hello World");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_움직임_성공() {
        Car car = new Car("chang");
        car.move(() -> true);
        assertThat(car).isEqualTo(new Car("chang", 1));
        car.move(() -> true);
        assertThat(car).isEqualTo(new Car("chang", 2));
    }

    @Test
    void 자동차_움직임_실패() {
        Car car = new Car("chang");
        car.move(() -> false);
        assertThat(car).isEqualTo(new Car("chang", 0));
        car.move(() -> false);
        assertThat(car).isEqualTo(new Car("chang", 0));
    }

    @Test
    void 자동차_위치비교_일치() {
        Car chang = new Car("chang",3);
        Car mo = new Car("mo",3);
        assertThat(chang.samePosition(mo)).isTrue();
    }

    @Test
    void 자동차_위치비교_불일치_뒤처짐() {
        Car chang = new Car("chang",3);
        Car mo = new Car("mo",4);
        assertThat(chang).isLessThan(mo);
    }

    @Test
    void 자동차_위치비교_불일치_앞섬() {
        Car chang = new Car("chang",4);
        Car mo = new Car("mo",3);
        assertThat(chang).isGreaterThan(mo);
    }
}
