import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    @Test
    void 자동차_전진() {
        Car car = new Car("finn", 0);
        car.go();
        assertThat(car.isSameLocation(1)).isTrue();
    }

    @Test
    void 자동차_4이상이면_전진() {
        Car car = new Car("finn", 0);
        car.randomGo(4);
        assertThat(car.isSameLocation(1)).isTrue();
    }

    @Test
    void 자동차_4미만이면_멈춤() {
        Car car = new Car("finn", 0);
        car.randomGo(1);
        assertThat(car.isSameLocation(0)).isTrue();
    }

    @Test
    void 자동차_이름으로_생성() {
        Car car = new Car("finn", 0);
        assertThat(car.hasName("finn")).isTrue();
    }

    @Test
    void 자동차_이름_1자이상_5자이내() {
        assertThatThrownBy(() -> {
            new Car("finnnn", 0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Car("", 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
