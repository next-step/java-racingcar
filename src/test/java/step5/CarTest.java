package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.Car;
import step5.stretegy.MoveStrategy;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("moveStrategy에서 true인 값이 올 때만 1만큼 이동한다.")
    @ParameterizedTest
    @CsvSource(value= {"true:1", "false:0"}, delimiter = ':')
    void go(boolean movePossibility, int result) {
        Car car = new Car("0", new TestMoveStrategy(()->movePossibility));
        int beforeDistance = car.getDistance();
        int afterDistance = car.go().getDistance();
        assertThat(afterDistance - beforeDistance).isEqualTo(result);

    }

    private class TestMoveStrategy implements MoveStrategy {

        private BooleanSupplier supplier;

        TestMoveStrategy(BooleanSupplier supplier) {
            this.supplier = supplier;
        }

        @Override
        public boolean isAbleToMove() {
            return supplier.getAsBoolean();
        }
    }

}
