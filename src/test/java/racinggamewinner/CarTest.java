package racinggamewinner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 차이름5글자_초과실패() {
        Car car = new Car("redeee");
        assertThatThrownBy(() -> {
                    car.checkNameLength();
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void 이동여부_판단테스트(int randomNumber, int decisionResult) {
        Car car = new Car("red");
        assertThat(car.decideGoStop(randomNumber)).isEqualTo(decisionResult);
    }

}
