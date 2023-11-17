package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.movestrategy.FixedMoveStrategy;
import racingcar.model.movestrategy.MoveStrategy;
import racingcar.model.movestrategy.RandomMoveStrategy;

public class CarTest {

        @Test
        void 자동차_이름이_5자를_초과할_경우_에러() {
                String text = "aaaaaa";
                assertThatThrownBy(() -> new Car(text, new RandomMoveStrategy())).isInstanceOf(
                    IllegalArgumentException.class);
        }

        @Test
        void 랜덤_값이_4이상일_경우_전진() {
                MoveStrategy moveStrategy = new FixedMoveStrategy(4);
                Car car = new Car("name", moveStrategy);
                car.moveForwardIfCan();
                assertThat(car.currentPosition().getValue()).isEqualTo(2);
        }

        @Test
        void 랜덤_값이_4미만일_경우_전진하지_않음() {
                MoveStrategy moveStrategy = new FixedMoveStrategy(3);
                Car car = new Car("name", moveStrategy);
                car.moveForwardIfCan();
                assertThat(car.currentPosition().getValue()).isEqualTo(1);
        }
}
