package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @ParameterizedTest
    @ValueSource(strings = {"abcdef"})
    void 자동차_이름은_5자리를_초과하지않음(String strings) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(strings));
    }

    @Test
    void 랜덤_수에_따라_이동이_나눠진다() {
        Car car = new Car("sean");
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        car.move(numberGenerator);
        assertThat(Arrays.asList(0, 1).contains(car.getPosition()));
    }

    @Test
    void 자동차는_한칸씩_이동을_한다() {
        Car car = new Car("sean");
        NumberGenerator numberGenerator = new TestNumberGenerator();
        car.move(numberGenerator);
        assertThat(1).isEqualTo(car.getPosition());
    }
}
