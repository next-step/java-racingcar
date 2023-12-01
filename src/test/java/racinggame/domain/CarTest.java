package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.rule.TestFalseMoveStrategy;
import racinggame.domain.rule.TestTrueMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("A", 0);
    }

    @DisplayName("자동차 move에 true를 전달하면 position에 1만큼 더해 준다.")
    @Test
    void 자동차_전진_성공_테스트() {
        //when
        car.move(new TestTrueMoveStrategy());
        int result = car.getPosition();

        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("자동차 move에 false를 전달하면 position 변경이 없다.")
    @Test
    void 자동차_전진_불가_테스트() {
        //when
        car.move(new TestFalseMoveStrategy());
        int result = car.getPosition();

        //then
        assertThat(result).isEqualTo(0);
    }
}
