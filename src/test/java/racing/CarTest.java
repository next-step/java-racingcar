package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class CarTest {
    private static Car car;

    @BeforeEach
    void 셋업() {
        car = new Car("name");
    }

    @Test
    void create() {
        assertThat(new Car("ming", 1)).isEqualTo(new Car("ming", 1));
    }

    @Test
    void 주행거리() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 전진하면_주행거리_올라가거나_그대로() {
        assertThat(car.getDistance()).isEqualTo(0);
        car.run();
        assertThat(car.getDistance()).isIn(0, 1);
    }

    @Test
    void 이름() {
        assertThat(car.getName()).isEqualTo("name");
    }

    @Test
    void 이름_5자_초과하면_에러() {
        Throwable thrown = catchThrowable(() -> {car = new Car("sample_name");});
        assertThat(thrown).hasMessageContaining("최대 5글자까지 입력 가능합니다.");
    }

    @Test
    void distance_동일한지_검사() {
        assertThat(new Car("name", 10).isDistance(new Car("name", 10))).isEqualTo(true);
    }

    @Test
    void distance_큰지_검사() {
        assertThat(new Car("name", 10).hasLogDistanceThan(new Car("name", 1))).isEqualTo(true);
    }
}
