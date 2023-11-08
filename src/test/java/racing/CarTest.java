package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.Car.*;

public class CarTest {


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    void 랜덤값이_4이상이면_전진한다(int randomNumber) {
        assertThat(isMove(randomNumber)).isTrue();
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤값이_4미만이면_전진하지_못한다(int randomNumber) {
        assertThat(isMove(randomNumber)).isFalse();
    }
}
