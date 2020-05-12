package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차는 4 이상인 값이 들어왔을때 움직인다.")
    @ParameterizedTest
    @CsvSource({"3,0", "4,1"})
    void move(int randomNumber, int location) {
        Car car = new Car();

        int actualLocation = car.move(randomNumber);

        assertThat(actualLocation).isEqualTo(location);
    }
}
