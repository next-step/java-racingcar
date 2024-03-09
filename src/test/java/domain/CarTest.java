package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @DisplayName("자동차를 이동한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void test01(int random, int x) {
        // given
        int moveCount = 1;
        Car car = new Car(moveCount);

        // when
        Position position = car.move(random);

        // then
        Assertions.assertThat(position.getX()).isEqualTo(x);
    }
}
