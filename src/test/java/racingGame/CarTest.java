package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 생성시 지정된 이름으로 생성되며 기본 이동거리는 0이다.")
    void create() {
        Car car = new Car("pobi");
        assertThat(car).isEqualTo(new Car("pobi", 0));
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void validCarName() {
        assertThatThrownBy(() -> new Car("dododo"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("자동차 거리는 음수가 될 수 없다.")
    void validCarDistance() {
        assertThatThrownBy(() -> new Car("dododo", -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("매개변수가 4 이상일때 이동한다.")
    void moveGraterOrEqualThan4() {
        assertThat(new Car("pobi").move(4)).isEqualTo(new Car("pobi", 1));
        assertThat(new Car("pobi", 5).move(5)).isEqualTo(new Car("pobi", 6));
    }

    @Test
    @DisplayName("매개변수가 3 이하일때 이동하지 않는다.")
    void moveGraterOrEqualThan3() {
        assertThat(new Car("pobi").move(3)).isEqualTo(new Car("pobi", 0));
        assertThat(new Car("pobi", 4).move(0)).isEqualTo(new Car("pobi", 4));
    }
}
