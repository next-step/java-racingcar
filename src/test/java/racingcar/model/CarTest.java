package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.enums.Status;
import racingcar.model.wrapper.ForwardNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 동등_비교(int number) {
        Car actual = new Car(new ForwardNumber(number));
        Car expected = new Car(new ForwardNumber(number));
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void number_값이_4_이상일_경우_전진한다(int number) {
        Car actual = new Car(new ForwardNumber(number));
        Car expected = new Car(Status.FORWARD);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void number_값이_4_미만일_경우_멈춘다(int number) {
        Car actual = new Car(new ForwardNumber(number));
        Car expected = new Car(Status.STOP);
        assertThat(actual).isEqualTo(expected);
    }
}
