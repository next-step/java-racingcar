package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차의_getCondifionNumber_메소드의_값은_0에서_9사이의_값이다() {
        Car car = new Car();

        int conditionNumber = car.getConditionNumber();

        assertThat(conditionNumber).isBetween(0, 9);
    }

    @Test
    void 자동차를_생성하면_전진하는_방향이_하나_생성된다() {
        Car car = new Car();

        int forwardResult = car.getForwardResult();

        assertThat(forwardResult).isEqualTo(1);
    }

    @Test
    void 자동차_진행조건인_4이상의_수가_주어지면_한칸_전진한다() {
        Car car = new Car();

        int conditionNumber = 4;

        car.forward(conditionNumber);

        assertThat(car.getForwardResult()).isEqualTo(2);
    }
}
