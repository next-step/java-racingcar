package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class CarTest {

    @DisplayName("입력받은수가 4이상이고 9이하이면 전진한다.")
    @ParameterizedTest
    @CsvSource(value ={"1,0","2,0","4,1","9,1","10,0"})
    void name(int moveNumber, int actualResult) {
        Car car = new Car();
        car.move(moveNumber);
        int result = car.getMoveNumber();

        Assertions.assertThat(result).isEqualTo(actualResult);
    }
}
