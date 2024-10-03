package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @ParameterizedTest
    @DisplayName("random 값이 4 이상일 때, 차가 앞으로 1만큼 이동한다.")
    @CsvSource({"3, 0", "4, 1", "5, 1", "9, 1"})
    void forwardCarBasedOnRandomNumber(final int randomNumber, final int currentPosition) {
        //given
        new Car(new SpecifiedNumberGenerator(randomNumber));
        car.move();
        //then
        assertThat(car.getPosition()).isEqualTo(currentPosition);
    }

}
