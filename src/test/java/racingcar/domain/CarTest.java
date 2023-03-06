package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {
    @DisplayName("자동차는 이름을 가진다")
    @ParameterizedTest
    @ValueSource(strings = {"irene", "jason"})
    void name (final String name) {
//        var car = new Car("irene", 0);
        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.")
    @Test
    public void name() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car ("어쩌구저쩌구저쩌구"));
    }

    
}
