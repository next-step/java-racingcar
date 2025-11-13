package study.racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    @Test
    void 자동차위치의_초기값은_0이다() {
        CarPosition carPosition = new CarPosition();
        assertThat(carPosition.getValue()).isZero();
    }

    @Test
    void 자동차위치를_증가시키면_증가된_자동차위치를_반환한다() {
        CarPosition increasedCarPosition = new CarPosition().increase();

        assertThat(increasedCarPosition.getValue()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:true", "6:false"}, delimiter = ':')
    void 위치가_주어진_값보다_크면_true를_작거나같으면_falsue를_반환한다(int input, boolean expected) {
        CarPosition position = new CarPosition(5);
        assertThat(position.isGreaterThan(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:true", "3:false"}, delimiter = ':')
    void 위치가_주어진_값과_같으면_true_다르면_false를_반환한다(int input, boolean expected) {
        CarPosition position = new CarPosition(5);
        assertThat(position.isEqualTo(input)).isEqualTo(expected);
    }

    @Test
    void 같은_위치이면_동등성을_가진다() {
        CarPosition carPosition1 = new CarPosition();
        CarPosition carPosition2 = new CarPosition();

        assertThat(carPosition1).isEqualTo(carPosition2);
    }
}
