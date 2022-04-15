package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car("pobi");
    }

    /**
     * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
     */
    @DisplayName("전진 조건 테스트")
    @Test
    void random_count_test(){
        assertThat(car.isMove(() -> true)).isTrue();
        assertThat(car.isMove(() -> false)).isFalse();
    }

    /**
     * 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
     */
    @DisplayName("Car 이름 5자 초과 valid 확인 테스트")
    @Test
    void car_name_vaild_test(){
        assertThatThrownBy(() -> new Car("overfivename"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("전진 조건에 의한 이동거리 테스트")
    @Test
    void move_test(){
        Car car = new Car("pobi");
        car.isMove(() -> true);
        car.isMove(() -> true);
        car.isMove(() -> true);
        assertThat(car.getDistance()).isEqualTo(3);
    }

    @DisplayName("전진 조건에 의한 화면 표현 테스트")
    @Test
    void show_distance_test(){
        Car car = new Car("pobi");
        car.isMove(() -> true);
        car.isMove(() -> true);
        car.isMove(() -> true);
        assertThat(car.getShowDistance()).isEqualTo("pobi : ---");
    }
}