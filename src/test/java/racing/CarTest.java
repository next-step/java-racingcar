package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

//    @DisplayName(value = "랜덤 값이 4이상이면, 전진")
//    @ParameterizedTest
//    @CsvSource(value = {"0,1, 1,2, 2,3"})
//    void forwardMove(int oldPosition, int newPosition) {
//        // given
//        Car car = new Car(oldPosition, "david");
//
//        // when
//        car.move(() -> true);
//
//        // then
//        Assertions.assertThat(car.getPosition()).isEqualTo(newPosition);
//    }
//
//    @DisplayName(value = "랜덤 값이 4미만이면, 정지")
//    @Test
//    void stopMove() {
//        // given
//        Car car = new Car(0, "david");
//
//        // when
//        car.move(() -> false);
//
//        // then
//        Assertions.assertThat(car.getPosition()).isEqualTo(0);
//    }
}