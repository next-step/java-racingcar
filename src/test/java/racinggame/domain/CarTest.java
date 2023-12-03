package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.rule.TestFalseMoveStrategy;
import racinggame.rule.TestTrueMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 move에 true를 전달하면 position에 1만큼 더해 준다.")
    @Test
    void 자동차_전진_성공_테스트() {
        //given
        Car carA = new Car("A", 0, new TestTrueMoveStrategy());

        //when
        carA.move();
        int result = carA.getPosition();

        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("자동차 move에 false를 전달하면 position 변경이 없다.")
    @Test
    void 자동차_전진_불가_테스트() {
        //given
        Car carB = new Car("B", 0, new TestFalseMoveStrategy());

        //when
        carB.move();
        int result = carB.getPosition();

        //then
        assertThat(result).isEqualTo(0);
    }
}
