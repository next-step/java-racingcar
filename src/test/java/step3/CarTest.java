package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.stretegy.MoveStrategy;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("moveStrategy에서 true인 값이 올 때만 1만큼 이동한다.")
    @ParameterizedTest
    @CsvSource(value= {"true:1", "false:0"}, delimiter = ':')
    void go(boolean movePossibility, Integer result) {
        Car car = new Car(new TestMoveStrategy(()->movePossibility));
        Integer beforeDistance = car.getDistance();
        Integer afterDistance = car.go().getDistance();
        assertThat(afterDistance - beforeDistance).isEqualTo(result);

    }

    private class TestMoveStrategy implements MoveStrategy<Boolean> {

        private Supplier<Boolean> supplier;

        TestMoveStrategy(Supplier<Boolean> supplier) {
            this.supplier = supplier;
        }

        @Override
        public Supplier<Boolean> attemptMove() {
            return supplier;
        }

        @Override
        public boolean isAbleToMove(Supplier<Boolean> supplier) {
            return supplier.get();
        }
    }

}
